package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.model.Seccion;
import com.CidenetShop.CidenetShopBackend.service.SeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seccion")
public class SeccionController {

    @Autowired
    SeccionService seccionService;

    @GetMapping("/list")
    public ResponseEntity<List<Seccion>>list(){
        List<Seccion> listSeccion = seccionService.findAll();
        return new ResponseEntity<List<Seccion>>(listSeccion, HttpStatus.OK);
    }
}
