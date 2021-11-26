package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.DetailSize;
import com.CidenetShop.CidenetShopBackend.model.Size;
import com.CidenetShop.CidenetShopBackend.repository.DetailSizeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DetailSizeServiceTest {

    @Mock
    private DetailSizeRepository detailSizeRepository;

    @InjectMocks
    private DetailSizeService detailSizeService;

    private DetailSize detailSize;
    private Size size;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        size = new Size();
        size.setName("L");
        detailSize = new DetailSize();
        detailSize.setIdSize(1L);
        detailSize.setSize(size);
        detailSize.setStock(10);

    }

    @Test
    void findAll() {
        when(detailSizeRepository.findAll()).thenReturn(Arrays.asList(detailSize));
        assertNotNull(detailSizeService.findAll());
        verify(detailSizeRepository,times(1)).findAll();
        assertEquals(Arrays.asList(detailSize),detailSizeService.findAll());
        assertEquals(detailSize.getIdSize(),detailSizeService.findAll().get(0).getIdSize());
    }
}