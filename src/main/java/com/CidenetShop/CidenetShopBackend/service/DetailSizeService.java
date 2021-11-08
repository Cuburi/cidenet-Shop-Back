package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.DetailSize;
import com.CidenetShop.CidenetShopBackend.repository.DetailSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailSizeService {
    @Autowired
    DetailSizeRepository detailSizeRepository;

    public List<DetailSize> findAll(){
        return detailSizeRepository.findAll();
    }
}
