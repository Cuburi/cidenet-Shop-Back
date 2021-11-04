package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.model.Detalle_Talla;
import com.CidenetShop.CidenetShopBackend.service.Detalle_TallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tallasStock")
public class Detalle_TallaController {
    @Autowired
    Detalle_TallService detalle_tallService;

    @GetMapping("/list")
    public ResponseEntity<List<Detalle_Talla>> list(){
        List<Detalle_Talla> listDetalle_Talla = detalle_tallService.findAll();
        return new ResponseEntity<List<Detalle_Talla>>(listDetalle_Talla, HttpStatus.OK);
    }
}
