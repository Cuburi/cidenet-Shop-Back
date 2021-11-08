package com.CidenetShop.CidenetShopBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "size", fetch = FetchType.EAGER)
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

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Set<DetailSize> getDetailSizes() {
        return detailSizes;
    }

    public void setDetailSizes(Set<DetailSize> detailSizes) {
        this.detailSizes = detailSizes;
    }
}
