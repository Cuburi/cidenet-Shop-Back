package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.DetailSale;
import com.CidenetShop.CidenetShopBackend.model.Sale;
import com.CidenetShop.CidenetShopBackend.repository.DetailSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailSaleService {
    @Autowired
    DetailSaleRepository detailSaleRepository;

    public List<DetailSale> findAll(){
        return detailSaleRepository.findAll();
    }

    public void save (DetailSale detailSale){
        detailSaleRepository.save(detailSale);
    }
}
