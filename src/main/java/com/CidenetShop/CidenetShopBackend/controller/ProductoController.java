package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.criteria.ProductoCriteria;
import com.CidenetShop.CidenetShopBackend.dto.BusquedaDTO;
import com.CidenetShop.CidenetShopBackend.model.Producto;
import com.CidenetShop.CidenetShopBackend.service.ProductoService;
import io.github.jhipster.service.filter.StringFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
//@CrossOrigin(origins = "http://)
public class ProductoController {

    @Autowired
    ProductoService  productoService;

    @PostMapping("/list")
    public ResponseEntity<List<Producto>> listProduct(@RequestBody BusquedaDTO busquedaDTO){
        ProductoCriteria productoCriteria = createCriteria(busquedaDTO);
        List<Producto> listProdcuto = productoService.findByCriteria(productoCriteria);
        return new ResponseEntity<List<Producto>>(listProdcuto, HttpStatus.OK);
    }

    private ProductoCriteria createCriteria (BusquedaDTO busquedaDTO){
        ProductoCriteria productoCriteria = new ProductoCriteria();
        if(busquedaDTO != null){
            if(!StringUtils.isBlank(busquedaDTO.getDescripcion())){
                StringFilter filter = new StringFilter();
                filter.setContains(busquedaDTO.getDescripcion());
                productoCriteria.setDescripcion(filter);
            }
            if(!StringUtils.isBlank(busquedaDTO.getMarca())){
                StringFilter filter = new StringFilter();
                filter.setContains(busquedaDTO.getMarca());
                productoCriteria.setMarca(filter);
            }
            if(!StringUtils.isBlank(busquedaDTO.getColor())){
                StringFilter filter = new StringFilter();
                filter.setContains(busquedaDTO.getColor());
                productoCriteria.setColor(filter);
            }
        }
        return productoCriteria;
    }

}
