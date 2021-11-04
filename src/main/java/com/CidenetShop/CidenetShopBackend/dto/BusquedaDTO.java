package com.CidenetShop.CidenetShopBackend.dto;

public class BusquedaDTO {
    //Las cadenas desde el front al back
    private String color;
    private String descripcion;
    private String marca;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
