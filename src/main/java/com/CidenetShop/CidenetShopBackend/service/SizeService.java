package com.CidenetShop.CidenetShopBackend.service;


import com.CidenetShop.CidenetShopBackend.model.Size;
import com.CidenetShop.CidenetShopBackend.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    @Autowired
    SizeRepository sizeRepository;

    public List<Size> findAll(){
        return sizeRepository.findAll();
    }
}
