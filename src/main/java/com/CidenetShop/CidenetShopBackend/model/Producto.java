package com.CidenetShop.CidenetShopBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String nombre;

    @NonNull
    private float precioVenta;

    private String image;

    @NonNull
    private String marca;

    @NonNull
    private String descripcion;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties("productos")
    private Color color;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties("productos")
    private Seccion seccion;

    @JsonIgnore
    @OneToMany(mappedBy = "producto",fetch = FetchType.EAGER)
    private Set<Detalle_Talla> detalle_Tallas = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @NonNull
    public String getMarca() {
        return marca;
    }

    public void setMarca(@NonNull String marca) {
        this.marca = marca;
    }

    @NonNull
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NonNull String descripcion) {
        this.descripcion = descripcion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Set<Detalle_Talla> getDetalle_Tallas() {
        return detalle_Tallas;
    }

    public void setDetalle_Tallas(Set<Detalle_Talla> detalle_Tallas) {
        this.detalle_Tallas = detalle_Tallas;
    }
}
