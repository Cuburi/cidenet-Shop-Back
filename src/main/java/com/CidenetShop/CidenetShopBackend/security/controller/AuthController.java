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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
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
            return new ResponseEntity(new Message("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        if(userService.existsByName(newUser.getName()))
            return new ResponseEntity(new Message("Usuario ya existe"),HttpStatus.BAD_REQUEST);
        if(userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("Email ya existe"),HttpStatus.BAD_REQUEST);

        User user = new User(newUser.getName(), newUser.getEmail(), newUser.getAddress(), newUser.getTypeId(), newUser.getDocument(), newUser.getPhone(), passwordEncoder.encode(newUser.getPassword()));

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

        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvaider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt,userDetails.getUsername(),userDetails.getAuthorities());
        return new ResponseEntity(jwtDto,HttpStatus.OK);
    }
}
