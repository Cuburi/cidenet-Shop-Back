package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.Color;
import com.CidenetShop.CidenetShopBackend.model.Sale;
import com.CidenetShop.CidenetShopBackend.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    @Autowired
    ColorRepository colorRepository;

    public List<Color> findAll(){
        return colorRepository.findAll();
    }

    public void save (Color color){
        colorRepository.save(color);
    }

    public boolean existsByName(String name){
        return colorRepository.existsByName(name);
    }

}
