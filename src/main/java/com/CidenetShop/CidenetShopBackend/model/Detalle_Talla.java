package com.CidenetShop.CidenetShopBackend.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(Detalle_TallaPKId.class)
public class Detalle_Talla {



    @Id
    private Long idProducto;
    @Id
    private Long idTalla;
    @ManyToOne(optional = false,cascade = CascadeType.REMOVE)
    @JoinColumn(name="idProducto",insertable = false, updatable = false)
    private Producto producto;



    @ManyToOne (optional = false,cascade = CascadeType.REMOVE)
    @JoinColumn(name="idTalla",insertable = false, updatable = false)
    private Talla talla;

    @NonNull
    private int stock;




    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Long idTalla) {
        this.idTalla = idTalla;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
