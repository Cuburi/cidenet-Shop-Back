package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.criteria.ProductCriteria;
import com.CidenetShop.CidenetShopBackend.model.Product;
import com.CidenetShop.CidenetShopBackend.repository.ProductRepository;
import io.github.jhipster.service.filter.StringFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StringFilter stringFilter;

    @Mock
    private ProductService productService;

    private Product product;

    private ProductCriteria productCriteria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        product = new Product();
        stringFilter = new StringFilter();
        product.setName("Vestido blanco");
        stringFilter.setContains("Vestido");
        productCriteria.setDescription(stringFilter);
    }

    @Test
    void findByCriteria() {
       when(productService.)
    }
}