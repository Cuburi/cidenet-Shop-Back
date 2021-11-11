package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.model.DetailSize;
import com.CidenetShop.CidenetShopBackend.service.DetailSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sizeStock")
@CrossOrigin(origins = "http://localhost:3000")
public class DetailSizeController {
    @Autowired
    DetailSizeService detailSizeService;

    @GetMapping("/list")
    public ResponseEntity<List<DetailSize>> list(){
        List<DetailSize> listDetailSize = detailSizeService.findAll();
        return new ResponseEntity<List<DetailSize>>(listDetailSize, HttpStatus.OK);
    }
}
