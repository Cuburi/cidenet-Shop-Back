package com.CidenetShop.CidenetShopBackend.criteria;

import io.github.jhipster.service.filter.StringFilter;

public class ProductCriteria {
    private StringFilter color;
    private StringFilter description;
    private StringFilter brand;
    private StringFilter section;

    public StringFilter getColor() {
        return color;
    }

    public void setColor(StringFilter color) {
        this.color = color;
    }

    public StringFilter getDescription() {
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public StringFilter getBrand() {
        return brand;
    }

    public void setBrand(StringFilter brand) {
        this.brand = brand;
    }

    public StringFilter getSection() {
        return section;
    }

    public void setSection(StringFilter section) {
        this.section = section;
    }
}
