package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.criteria.ProductCriteria;
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
        List<Product> listProdcuto = productService.findByCriteria(productCriteria);
        return new ResponseEntity<List<Product>>(listProdcuto, HttpStatus.OK);
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

}
