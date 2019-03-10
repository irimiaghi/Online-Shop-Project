package com.github.abureala.Abureala.controllers.dto;

public class NewProductDto {
    public static final String NEW_PRODUCT_FORM = "newProductForm";

    private String name;
    private String priceBuy;
    private String priceRent;

    public String getName() {
        return name;
    }

    public NewProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPriceBuy() {
        return priceBuy;
    }

    public NewProductDto setPriceBuy(String priceBuy) {
        this.priceBuy = priceBuy;
        return this;
    }

    public String getPriceRent() {
        return priceRent;
    }

    public NewProductDto setPriceRent(String priceRent) {
        this.priceRent = priceRent;
        return this;
    }
}
