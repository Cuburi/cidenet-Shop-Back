package com.CidenetShop.CidenetShopBackend.dto;

public class SearchDTO {
    //Las cadenas desde el front al back
    private String color;
    private String description;
    private String brand;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
