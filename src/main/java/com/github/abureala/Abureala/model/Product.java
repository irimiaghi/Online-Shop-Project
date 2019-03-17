package com.github.abureala.Abureala.model;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String priceBuy;

    @Column
    private String priceRent;

    public String getPriceBuy() {
        return priceBuy;
    }
    public void setPriceBuy(String priceBuy) {
        this.priceBuy = priceBuy;
    }

    public String getPriceRent() {
        return priceRent;
    }
    public void setPriceRent(String priceRent) {
        this.priceRent = priceRent;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
