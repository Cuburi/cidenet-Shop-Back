package com.CidenetShop.CidenetShopBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name="name")
    private String name;

    @NonNull
    private float salePrice;

    @Lob
    private byte[] image;

    @NonNull
    private String brand;

    @NonNull
    private String description;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties("products")
    private Color color;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties("products")
    private Section section;

    @JsonIgnore
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private Set<DetailSize> detailSizes = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String nombre) {
        this.name = nombre;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float precioVenta) {
        this.salePrice = precioVenta;
    }



    @NonNull
    public String getBrand() {
        return brand;
    }

    public void setBrand(@NonNull String marca) {
        this.brand = marca;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String descripcion) {
        this.description = descripcion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<DetailSize> getDetailSizes() {
        return detailSizes;
    }

    public void setDetailSizes(Set<DetailSize> detailSizes) {
        this.detailSizes = detailSizes;
    }
}
