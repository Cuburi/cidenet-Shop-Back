package com.CidenetShop.CidenetShopBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Talla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(unique = true)
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "talla", fetch = FetchType.EAGER)
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

    public Set<Detalle_Talla> getDetalle_Tallas() {
        return detalle_Tallas;
    }

    public void setDetalle_Tallas(Set<Detalle_Talla> detalle_Tallas) {
        this.detalle_Tallas = detalle_Tallas;
    }
}
