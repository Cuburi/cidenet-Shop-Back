package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.Seccion;
import com.CidenetShop.CidenetShopBackend.repository.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeccionService {

    @Autowired
    SeccionRepository seccionRepository;

    public List<Seccion> findAll(){
        return seccionRepository.findAll();
    }
}
