package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.dto.Message;
import com.CidenetShop.CidenetShopBackend.model.DetailSize;
import com.CidenetShop.CidenetShopBackend.model.DetailSizePkId;
import com.CidenetShop.CidenetShopBackend.model.Product;
import com.CidenetShop.CidenetShopBackend.service.DetailSizeService;
import com.CidenetShop.CidenetShopBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    ProductService productService;

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

    @PutMapping("/newStock/{idSize}/{idProduct}/{account}")
    public ResponseEntity<?> updateStock (@PathVariable("idSize")Long idSize, @PathVariable("idProduct")Long idProduct ,@PathVariable("account")int account ){
        DetailSizePkId idDetailSize = new DetailSizePkId(idProduct,idSize);
        if(!detailSizeService.existsById(idDetailSize))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        DetailSize updateDetailSize = detailSizeService.getOne(idDetailSize).get();
        if(updateDetailSize.getStock()-account < 0)
            return new ResponseEntity(new Message("Error en la compra"),HttpStatus.BAD_REQUEST);
        updateDetailSize.setStock(updateDetailSize.getStock()-account);
        detailSizeService.save(updateDetailSize);
        return  new ResponseEntity(new Message("Stock modificado"),HttpStatus.OK);
    }

    @GetMapping("/{idSize}/{idProduct}")
    public ResponseEntity<DetailSize> seachDetailSize (@PathVariable("idSize")Long idSize, @PathVariable("idProduct")Long idProduct){
        DetailSizePkId idDetailSize = new DetailSizePkId(idProduct,idSize);
        if(!detailSizeService.existsById(idDetailSize))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        DetailSize detailSizeStock = detailSizeService.getOne(idDetailSize).get();
        return new ResponseEntity(detailSizeStock,HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody DetailSize detailSize){
        DetailSizePkId idDetailSize = new DetailSizePkId(detailSize.getIdProduct(),detailSize.getIdSize());
        if(detailSizeService.existsById(idDetailSize)){
            DetailSize updateDetailSize = detailSizeService.getOne(idDetailSize).get();
            updateDetailSize.setStock(updateDetailSize.getStock()+detailSize.getStock());
            detailSizeService.save(updateDetailSize);
            return new ResponseEntity(new Message("Stock actualizado"), HttpStatus.OK);
        }
        DetailSize newDetailSize = new DetailSize(detailSize.getIdProduct(),detailSize.getIdSize(),detailSize.getProduct(),detailSize.getSize(),detailSize.getStock());
        detailSizeService.save(newDetailSize);
        Product productActive = productService.getOne(detailSize.getIdProduct()).get();
        productActive.setActive(true);
        productService.save(productActive);
        return new ResponseEntity(new Message("Stock creado"), HttpStatus.OK);
    }

}
