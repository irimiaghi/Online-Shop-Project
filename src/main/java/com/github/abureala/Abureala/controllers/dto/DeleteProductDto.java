package com.github.abureala.Abureala.controllers.dto;

public class DeleteProductDto {

    public static final String DELETE_PRODUCT_FORM = "deleteProductForm";
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public DeleteProductDto setProductId(Long productId) {
        this.productId = productId;
        return this;
    }
}
