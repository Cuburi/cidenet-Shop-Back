package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.model.Brand;
import com.CidenetShop.CidenetShopBackend.model.Section;
import com.CidenetShop.CidenetShopBackend.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin(origins = "http://localhost:3000")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping("/list")
    public ResponseEntity<List<Brand>> list(){
        List<Brand> listBrand = brandService.findAll();
        return new ResponseEntity<List<Brand>>(listBrand, HttpStatus.OK);
    }
}
