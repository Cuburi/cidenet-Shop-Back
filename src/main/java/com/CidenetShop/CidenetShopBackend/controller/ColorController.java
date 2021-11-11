package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.model.Color;
import com.CidenetShop.CidenetShopBackend.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
