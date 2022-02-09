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
    private String description;

    @NonNull
    private boolean active;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties("products")
    private Brand brand;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties("products")
    private Color color;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties("products")
    private Section section;

    @JsonIgnore
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private Set<DetailSize> detailSizes = new HashSet<>();

    public Product() {

    }

    public Product(long id, @NonNull String name, float salePrice, byte[] image, @NonNull String description, Brand brand, Color color, Section section, int accountVisit) {
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.image = image;
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.section = section;
        this.accountVisit = accountVisit;
        this.active = false;
    }

    private int accountVisit;

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


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String descripcion) {
        this.description = descripcion;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public int getAccountVisit() {
        return accountVisit;
    }

    public void setAccountVisit(int accountVisit) {
        this.accountVisit = accountVisit;
    }
}
