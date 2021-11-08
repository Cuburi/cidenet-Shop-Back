package com.CidenetShop.CidenetShopBackend.controller;

import com.CidenetShop.CidenetShopBackend.model.Section;
import com.CidenetShop.CidenetShopBackend.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController {

    @Autowired
    SectionService sectionService;

    @GetMapping("/list")
    public ResponseEntity<List<Section>>list(){
        List<Section> listSection = sectionService.findAll();
        return new ResponseEntity<List<Section>>(listSection, HttpStatus.OK);
    }
}
