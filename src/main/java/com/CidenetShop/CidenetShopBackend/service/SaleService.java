package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.Sale;
import com.CidenetShop.CidenetShopBackend.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    public List<Sale> findAll(){
        return saleRepository.findAll();
    }
    
    public Sale save (Sale sale){
         saleRepository.save(sale);
         return sale;
    }
}
