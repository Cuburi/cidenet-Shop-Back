package com.CidenetShop.CidenetShopBackend.service;


import com.CidenetShop.CidenetShopBackend.model.Brand;
import com.CidenetShop.CidenetShopBackend.model.Color;
import com.CidenetShop.CidenetShopBackend.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public List<Brand> findAll(){
        return brandRepository.findAll();
    }

    public void save (Brand brand){
        brandRepository.save(brand);
    }

    public boolean existsByName(String name){
        return brandRepository.existsByName(name);
    }
}
