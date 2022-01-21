package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.criteria.ProductCriteria;
import com.CidenetShop.CidenetShopBackend.dto.Message;
import com.CidenetShop.CidenetShopBackend.dto.SearchDTO;
import com.CidenetShop.CidenetShopBackend.model.Product;
import com.CidenetShop.CidenetShopBackend.service.ProductService;
import io.github.jhipster.service.filter.StringFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/list")
    public ResponseEntity<List<Product>> listProduct(@RequestBody SearchDTO searchDTO){
        ProductCriteria productCriteria = createCriteria(searchDTO);
        List<Product> listProduct = productService.findByCriteria(productCriteria);
        return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
    }

    private ProductCriteria createCriteria (SearchDTO searchDTO){
        ProductCriteria productCriteria = new ProductCriteria();
        if(searchDTO != null){
            if(!StringUtils.isBlank(searchDTO.getDescription())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchDTO.getDescription());
                productCriteria.setDescription(filter);
            }
            if(!StringUtils.isBlank(searchDTO.getBrand())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchDTO.getBrand());
                productCriteria.setBrand(filter);
            }
            if(!StringUtils.isBlank(searchDTO.getColor())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchDTO.getColor());
                productCriteria.setColor(filter);
            }
            if(!StringUtils.isBlank(searchDTO.getSection())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchDTO.getSection());
                productCriteria.setSection(filter);
            }
        }
        return productCriteria;
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<Product>> list (){
        List<Product> products = productService.findAll();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/list-order")
    public ResponseEntity<List<Product>> listByOrder (){
        List<Product> products = productService.findAll();
        productService.findAllByTop(products);
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @PutMapping("/accountVisit/{idProduct}")
    public ResponseEntity<?> updateAccountVisit (@PathVariable ("idProduct") Long idProduct){
        if(!productService.existById(idProduct)){
            return new ResponseEntity(new Message("No existe producto con ese id"),HttpStatus.NOT_FOUND);
        }
        Product product = productService.getOne(idProduct).get();

        product.setAccountVisit(product.getAccountVisit()+1);
        productService.save(product);
        return new ResponseEntity(new Message("Account modificado"),HttpStatus.OK);
    }
}
