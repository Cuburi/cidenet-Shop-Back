package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.model.Section;
import com.CidenetShop.CidenetShopBackend.repository.SectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SectionServiceTest {

    @Mock
    private SectionRepository sectionRepository;

    @InjectMocks
    private SectionService sectionService;

    private Section section;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        section = new Section();
        section.setName("Mujer");
    }

    @Test
    void findAll() {
        when(sectionRepository.findAll()).thenReturn(Arrays.asList(section));
        assertNotNull(sectionService.findAll());
        verify(sectionRepository,times(1)).findAll();
        assertEquals(Arrays.asList(section),sectionService.findAll());
        assertEquals(section.getName(),sectionService.findAll().get(0).getName());
    }
}