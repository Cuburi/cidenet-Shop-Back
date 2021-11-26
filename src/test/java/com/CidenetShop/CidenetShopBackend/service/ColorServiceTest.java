package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.Color;
import com.CidenetShop.CidenetShopBackend.repository.ColorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ColorServiceTest {

    @Mock
    private ColorRepository colorRepository;

    @InjectMocks
    private ColorService colorService;

    private Color color;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        color = new Color();
        color.setName("Negro");
    }

    @Test
    void findAll() {
        when(colorRepository.findAll()).thenReturn(Arrays.asList(color));
        assertNotNull(colorService.findAll());
        verify(colorRepository,times(1)).findAll();
        assertEquals(Arrays.asList(color),colorService.findAll());
        assertEquals(color.getName(),colorService.findAll().get(0).getName());

    }
}