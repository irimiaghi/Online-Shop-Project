package com.github.abureala.Abureala.controllers.dto;

import com.github.abureala.Abureala.model.Product;

import java.util.List;

public class ProductListFormDto {
    private static final String PRODUCT_LIST_FORM = "productListForm";
    List<Product> productList;


    public ProductListFormDto(List<Product> productList) {
        this.productList = productList;
    }

    public ProductListFormDto() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public ProductListFormDto setProductList(List<Product> productList) {
        this.productList = productList;
        return this;
    }

}
