package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.dto.Message;
import com.CidenetShop.CidenetShopBackend.model.Color;
import com.CidenetShop.CidenetShopBackend.service.ColorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
@CrossOrigin(origins = "http://localhost:3000")
public class ColorController {
    @Autowired
    ColorService colorService;

    @GetMapping("/list")
    public ResponseEntity<List<Color>> list(){
        List<Color> listColor = colorService.findAll();
        return new ResponseEntity<List<Color>>(listColor, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody Color color){
        if(StringUtils.isBlank(color.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(colorService.existsByName(color.getName()))
            return new ResponseEntity(new Message("Este color ya existe"), HttpStatus.BAD_REQUEST);
        Color newColor = new Color(color.getId(),color.getName());
        colorService.save(newColor);
        return new ResponseEntity(new Message("Color creado"), HttpStatus.OK);
    }

}
