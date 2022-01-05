package com.CidenetShop.CidenetShopBackend.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@IdClass(DetailSizePkId.class)
public class DetailSize {

    @Id
    private Long idProduct;
    @Id
    private Long idSize;
    @ManyToOne(optional = false,cascade = CascadeType.REMOVE)
    @JoinColumn(name="idProduct",insertable = false, updatable = false)
    private Product product;



    @ManyToOne (optional = false,cascade = CascadeType.REMOVE)
    @JoinColumn(name="idSize",insertable = false, updatable = false)
    private Size size;

    @NonNull
    private int stock;


    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProducto) {
        this.idProduct = idProducto;
    }

    public Long getIdSize() {
        return idSize;
    }

    public void setIdSize(Long idTalla) {
        this.idSize = idTalla;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
