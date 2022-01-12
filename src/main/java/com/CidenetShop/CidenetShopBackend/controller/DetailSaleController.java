package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.dto.Message;
import com.CidenetShop.CidenetShopBackend.model.DetailSale;
import com.CidenetShop.CidenetShopBackend.service.DetailSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/detailSale")
@CrossOrigin(origins = "http://localhost:3000")
public class DetailSaleController {
    @Autowired
    DetailSaleService detailSaleService;

    @GetMapping("/list")
    public ResponseEntity<List<DetailSale>>list(){
        List<DetailSale> listDetailSale = detailSaleService.findAll();
        return new ResponseEntity<List<DetailSale>>(listDetailSale,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody DetailSale detailSale){
        DetailSale newDetailSale = new DetailSale(detailSale.getIdProduct(),detailSale.getIdSale(),detailSale.getProduct(),detailSale.getSale(),detailSale.getAmount());
        detailSaleService.save(newDetailSale);
        return new ResponseEntity(new Message("Producto comprado"),HttpStatus.OK);
    }
}
