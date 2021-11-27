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
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StringFilter stringFilter;

    @InjectMocks
    private ProductService productService;

    private Product product;

   // private ProductCriteria productCriteria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        product = new Product();
        //stringFilter = new StringFilter();
        product.setName("Vestido blanco");
        //stringFilter.setContains("Vestido");
        //productCriteria.setDescription(stringFilter);
    }

    @Test
    void findByCriteria() {
       when(productRepository.findAll(any(Specification.class))).thenReturn(Arrays.asList(product));
        System.out.println(when(productRepository.findAll(any(Specification.class))).thenReturn(Arrays.asList(product)));
        assertNotNull(productService.findByCriteria(any(ProductCriteria.class)));
        verify(productRepository,times(1)).findAll(any(Specification.class));
        assertEquals(Arrays.asList(product),productService.findByCriteria(any(ProductCriteria.class)));
        assertEquals(product.getName(),productService.findByCriteria(any(ProductCriteria.class)).get(0).getName());
    }
}