package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.DetailSize;
import com.CidenetShop.CidenetShopBackend.model.DetailSizePkId;
import com.CidenetShop.CidenetShopBackend.repository.DetailSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailSizeService {
    @Autowired
    DetailSizeRepository detailSizeRepository;

    public List<DetailSize> findAll(){
        return detailSizeRepository.findAll();
    }

    public Optional<List<DetailSize>> getByProductId(Long idProduct){
        return detailSizeRepository.findByIdProduct(idProduct);
    }

    public boolean existsByIdProduct(Long idProduct){
        return detailSizeRepository.existsByIdProduct(idProduct);
    }

    public boolean existsById(DetailSizePkId idDetailSize){
        return detailSizeRepository.existsById(idDetailSize);
    }

    public Optional<DetailSize> getOne(DetailSizePkId idDetailSize){
        return detailSizeRepository.findById(idDetailSize);
    }

    public void  save(DetailSize detailSize){
        detailSizeRepository.save(detailSize);
    }
}
