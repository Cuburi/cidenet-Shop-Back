package com.CidenetShop.CidenetShopBackend.emailPassword.controller;

import com.CidenetShop.CidenetShopBackend.dto.Message;
import com.CidenetShop.CidenetShopBackend.emailPassword.dto.*;
import com.CidenetShop.CidenetShopBackend.emailPassword.service.EmailService;
import com.CidenetShop.CidenetShopBackend.security.model.User;
import com.CidenetShop.CidenetShopBackend.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/email-password")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {
    @Autowired
    EmailService emailService;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.mail.username}")
    private String mailFrom;


    private static final String subject = "Cambio de contraseña";

    private static final String subjectSale = "Confirmación de compra";

    private static final String subjectActiveAccount = "Activación de cuenta";

    @PostMapping("/send-email-sale")
    public ResponseEntity<?> sendEmailSale(@RequestBody EmailSaleValuesDTO dto){
        Optional<User> userOpt = userService.getByEmail(dto.getMailTo());
        if (!userOpt.isPresent())
            return  new ResponseEntity(new Message("No existe ningun usuario con ese correo"),HttpStatus.NOT_FOUND);
        User user = userOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(user.getEmail());
        dto.setSubject(subject);
        dto.setUserName(user.getName());
        dto.setSubject(subjectSale);
        emailService.sendEmailSale(dto);
        return new ResponseEntity(new Message("Te hemos enviado un correo"), HttpStatus.OK);
    }


    @PostMapping("/send-email-active")
    public ResponseEntity<?> sendEmailActive (@RequestBody EmailActiveAccountDTO dto){
        Optional<User> userOpt = userService.getByEmail(dto.getMailTo());
        if (!userOpt.isPresent())
            return  new ResponseEntity(new Message("No existe ningun usuario con ese correo"),HttpStatus.NOT_FOUND);
        User user = userOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(user.getEmail());
        dto.setSubject(subjectActiveAccount);
        dto.setUserName(user.getName());
        UUID uuid = UUID.randomUUID();
        String tokenActive = uuid.toString();
        dto.setTokenActive(tokenActive);
        user.setTokenActive(tokenActive);
        userService.save(user);
        emailService.sendEmailActiveAccount(dto);
        return new ResponseEntity(new Message("Te hemos enviado un correo"), HttpStatus.OK);
    }

    @PostMapping("/active-account")
    public ResponseEntity<?> changeActiveAccount(@Valid @RequestBody ActiveAccountDTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Campos incorrectos"), HttpStatus.BAD_REQUEST);
        Optional<User> userOpt = userService.getByTokenActive(dto.getTokenActive());
        if (!userOpt.isPresent())
            return  new ResponseEntity(new Message("No existe ningun usuario con esas credenciales"),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        User user = userOpt.get();
        user.setActive(true);
        user.setTokenActive(null);
        userService.save(user);
        return new ResponseEntity(new Message("Cuenta activada"),HttpStatus.OK);
    }


    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmailTemplate (@RequestBody EmailValuesDTO dto){
        Optional<User> userOpt = userService.getByEmail(dto.getMailTo());
        if (!userOpt.isPresent())
            return  new ResponseEntity(new Message("No existe ningun usuario con ese correo"),HttpStatus.NOT_FOUND);
        User user = userOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(user.getEmail());
        dto.setSubject(subject);
        dto.setUserName(user.getName());
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setTokenPassword(tokenPassword);
        user.setTokenPassword(tokenPassword);
        userService.save(user);
        emailService.sendEmail(dto);
        return new ResponseEntity(new Message("Te hemos enviado un correo"), HttpStatus.OK);
    }



    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Campos incorrectos"), HttpStatus.BAD_REQUEST);
        if(!dto.getPassword().equals(dto.getConfirmPassword()))
            return new ResponseEntity(new Message("Contraseñas no coinciden"), HttpStatus.BAD_REQUEST);
        Optional<User> userOpt = userService.getByTokenPassword(dto.getTokenPassword());
        if (!userOpt.isPresent())
            return  new ResponseEntity(new Message("No existe ningun usuario con esas credenciales"),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        User user = userOpt.get();
        String newPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(newPassword);
        user.setTokenPassword(null);
        userService.save(user);
        return new ResponseEntity(new Message("Contraseña actualizada"),HttpStatus.OK);
    }



}
