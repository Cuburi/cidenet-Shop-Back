package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.Detalle_Talla;
import com.CidenetShop.CidenetShopBackend.repository.Detalle_TallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Detalle_TallService {
    @Autowired
    Detalle_TallaRepository detalle_tallaRepository;

    public List<Detalle_Talla> findAll(){
        return detalle_tallaRepository.findAll();
    }
}
