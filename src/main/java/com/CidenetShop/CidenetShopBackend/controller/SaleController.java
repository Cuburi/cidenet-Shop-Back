package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.dto.Message;
import com.CidenetShop.CidenetShopBackend.model.Sale;
import com.CidenetShop.CidenetShopBackend.repository.SaleRepository;
import com.CidenetShop.CidenetShopBackend.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
@CrossOrigin(origins = "http://localhost:3000")
public class SaleController {
    @Autowired
    SaleService saleService;

    @GetMapping("/list")
    public ResponseEntity<List<Sale>> list(){
        List<Sale> listSale = saleService.findAll();
        return new ResponseEntity<List<Sale>>(listSale, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody Sale sale){
        Sale newSale = new Sale(sale.getId(), sale.getTotalPrice(), sale.getDate(), sale.getUser());
        saleService.save(newSale);
        return new ResponseEntity(new Message("Compra creado"),HttpStatus.OK);
    }
}
