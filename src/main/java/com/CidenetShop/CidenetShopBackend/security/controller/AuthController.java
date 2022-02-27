package com.CidenetShop.CidenetShopBackend.security.controller;

import com.CidenetShop.CidenetShopBackend.dto.Message;
import com.CidenetShop.CidenetShopBackend.security.dto.JwtDto;
import com.CidenetShop.CidenetShopBackend.security.dto.LoginUser;
import com.CidenetShop.CidenetShopBackend.security.dto.NewUser;
import com.CidenetShop.CidenetShopBackend.security.enums.RoleName;
import com.CidenetShop.CidenetShopBackend.security.jwt.JwtProvaider;
import com.CidenetShop.CidenetShopBackend.security.model.Role;
import com.CidenetShop.CidenetShopBackend.security.model.User;
import com.CidenetShop.CidenetShopBackend.security.service.RoleService;
import com.CidenetShop.CidenetShopBackend.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvaider jwtProvaider;

    @PostMapping("/new")
    public ResponseEntity<?> newUser (@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Campos mal puestos o email invalido"), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        if(userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("Email ya existe"),HttpStatus.NON_AUTHORITATIVE_INFORMATION);

        User user = new User(newUser.getName(), newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword()),
                newUser.getTypeId(),
                newUser.getDocument(),
                newUser.getAddress(),
                newUser.getPhone());

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
        if (newUser.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());

        user.setRoles(roles);

        userService.save(user);
        return new ResponseEntity(new Message("Usuario guardado"), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<JwtDto> login (@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        Optional<User> userOpt = userService.getByEmail(loginUser.getEmail());
        if (!userOpt.isPresent())
            return  new ResponseEntity(new Message("No existe ningun usuario con esas credenciales"),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        User user = userOpt.get();
        if(!user.isActive())
            return new ResponseEntity(new Message("Cuenta inactiva"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvaider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto,HttpStatus.OK);
    }

    @GetMapping("/userEmail/{email}")
    public ResponseEntity<User> getByEmailUser (@PathVariable("email")String email){
        if (!userService.existsByEmail(email)){
            return new ResponseEntity(new Message("Usuario no existe"),HttpStatus.NOT_FOUND);
        }
        User user = userService.getByEmail(email).get();
        return new ResponseEntity(user,HttpStatus.OK);
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<User> getByIdUser (@PathVariable("idUser")Long idUser){
        if (!userService.existsById(idUser)){
            return new ResponseEntity(new Message("Usuario no existe"),HttpStatus.NOT_FOUND);
        }
        User user = userService.getById(idUser).get();
        return new ResponseEntity(user,HttpStatus.OK);
    }
}
