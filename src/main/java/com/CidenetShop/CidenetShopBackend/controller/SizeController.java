package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.model.Size;
import com.CidenetShop.CidenetShopBackend.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/size")
@CrossOrigin(origins = "http://localhost:3000")
public class SizeController {
    @Autowired
    SizeService sizeService;

    @GetMapping("/list")
    public ResponseEntity<List<Size>> list(){
        List<Size> listSize = sizeService.findAll();
        return new ResponseEntity<List<Size>>(listSize, HttpStatus.OK);
    }
}
