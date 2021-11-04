package com.CidenetShop.CidenetShopBackend.criteria;

import io.github.jhipster.service.filter.StringFilter;

public class ProductoCriteria {
    private StringFilter color;
    private StringFilter descripcion;
    private StringFilter Marca;

    public StringFilter getColor() {
        return color;
    }

    public void setColor(StringFilter color) {
        this.color = color;
    }

    public StringFilter getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(StringFilter descripcion) {
        this.descripcion = descripcion;
    }

    public StringFilter getMarca() {
        return Marca;
    }

    public void setMarca(StringFilter marca) {
        Marca = marca;
    }
}
