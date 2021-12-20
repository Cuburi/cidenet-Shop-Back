package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.dto.Message;
import com.CidenetShop.CidenetShopBackend.model.DetailSize;
import com.CidenetShop.CidenetShopBackend.model.DetailSizePkId;
import com.CidenetShop.CidenetShopBackend.service.DetailSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/sizeStock")
@CrossOrigin(origins = "http://localhost:3000")
public class DetailSizeController {
    @Autowired
    DetailSizeService detailSizeService;

    @GetMapping("/list")
    public ResponseEntity<List<DetailSize>> list(){
        List<DetailSize> listDetailSize = detailSizeService.findAll();
        return new ResponseEntity<List<DetailSize>>(listDetailSize, HttpStatus.OK);
    }

    @GetMapping("/stock/{idProduct}")
    public ResponseEntity<List<DetailSize>> getByIdProduct (@PathVariable("idProduct") Long idProduct){
        if(!detailSizeService.existsByIdProduct(idProduct))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        List<DetailSize> listSetailSize = detailSizeService.getByProductId(idProduct).get();
        return new ResponseEntity(listSetailSize, HttpStatus.OK);
    }

    @PutMapping("/update/{idSize}/{idProduct}/{account}")
    public ResponseEntity<?> updateStock (@PathVariable("idSize")Long idSize, @PathVariable("idProduct")Long idProduct ,@PathVariable("account")int value ){
        DetailSizePkId idDetailSize = new DetailSizePkId(idProduct,idSize);
        if(!detailSizeService.existsById(idDetailSize))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        DetailSize updateDetailSize = detailSizeService.getOne(idDetailSize).get();
        updateDetailSize.setStock(updateDetailSize.getStock()-value);
        detailSizeService.save(updateDetailSize);
        return  new ResponseEntity(new Message("Producto creado"),HttpStatus.OK);
    }



    @GetMapping("/search/{idSize}/{idProduct}")
    public ResponseEntity<DetailSize> seachDetailSize (@PathVariable("idSize")Long idSize, @PathVariable("idProduct")Long idProduct){
        DetailSizePkId idDetailSize = new DetailSizePkId(idProduct,idSize);
        if(!detailSizeService.existsById(idDetailSize))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        DetailSize detailSizeStock = detailSizeService.getOne(idDetailSize).get();
        return new ResponseEntity(detailSizeStock,HttpStatus.OK);
    }

}
