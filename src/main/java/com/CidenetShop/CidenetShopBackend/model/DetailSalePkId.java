package com.CidenetShop.CidenetShopBackend.model;

import java.io.Serializable;

public class DetailSalePkId implements Serializable {
    private Long idProduct;
    private Long idSale;

    public DetailSalePkId(Long idProduct, Long idSale) {
        this.idProduct = idProduct;
        this.idSale = idSale;
    }

    public DetailSalePkId() {
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdSale() {
        return idSale;
    }

    public void setIdSale(Long idSale) {
        this.idSale = idSale;
    }
}
