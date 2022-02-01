package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.dto.Message;
import com.CidenetShop.CidenetShopBackend.model.Brand;
import com.CidenetShop.CidenetShopBackend.model.Color;
import com.CidenetShop.CidenetShopBackend.model.Section;
import com.CidenetShop.CidenetShopBackend.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody Brand brand){
        if(StringUtils.isBlank(brand.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(brandService.existsByName(brand.getName()))
            return new ResponseEntity(new Message("Esta marca ya existe"), HttpStatus.BAD_REQUEST);
        Brand newBrand = new Brand(brand.getId(),brand.getName());
        brandService.save(newBrand);
        return new ResponseEntity(new Message("Marca creado"), HttpStatus.OK);
    }
}
