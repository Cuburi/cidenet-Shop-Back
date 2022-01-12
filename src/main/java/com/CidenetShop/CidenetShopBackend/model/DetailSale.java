package com.CidenetShop.CidenetShopBackend.model;


import javax.persistence.*;

@Entity
@IdClass(DetailSalePkId.class)
public class DetailSale {
    @Id
    private Long idProduct;
    @Id
    private Long idSale;

    @ManyToOne(optional = false,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idProduct",insertable = false,updatable = false)
    private Product product;

    @ManyToOne(optional = false,cascade = CascadeType.REMOVE)
    @JoinColumn(name="idSale",insertable = false, updatable = false)
    private Sale sale;

    private int amount;

    public DetailSale(Long idProduct, Long idSale, Product product, Sale sale, int amount) {
        this.idProduct = idProduct;
        this.idSale = idSale;
        this.product = product;
        this.sale = sale;
        this.amount = amount;
    }

    public DetailSale() {

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
