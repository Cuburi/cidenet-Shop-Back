package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.Brand;
import com.CidenetShop.CidenetShopBackend.repository.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandService brandService;


    private Brand brand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        brand = new Brand();
        brand.setName("Nike");
    }

    @Test
    void findAll() {
        when(brandRepository.findAll()).thenReturn(Arrays.asList(brand));
        assertNotNull(brandService.findAll());
        verify(brandRepository,times(1)).findAll();
        assertEquals(Arrays.asList(brand),brandService.findAll());
        assertEquals(brand.getName(),brandService.findAll().get(0).getName());
    }
}