package com.CidenetShop.CidenetShopBackend.model;

import java.io.Serializable;

public class DetailSizePkId implements Serializable {
    private Long idProduct;
    private Long idSize;

    public DetailSizePkId(Long idProduct, Long idSize) {
        this.idProduct = idProduct;
        this.idSize = idSize;
    }

    public DetailSizePkId() {
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdSize() {
        return idSize;
    }

    public void setIdSize(Long idSize) {
        this.idSize = idSize;
    }
}
