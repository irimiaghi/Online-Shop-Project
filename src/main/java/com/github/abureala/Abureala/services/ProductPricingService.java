package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.model.Product;

import java.util.Optional;
public interface ProductPricingService {

    Optional<Product> getProductById(Long id);
    Optional<String> getProductName(Long id);
    Optional<String> getProductBuyPrice(Long id);
    Optional<String> getProductRentPrice(Long id);

    Product createProduct(String name, String price_buy, String price_rent);

    void deleteProduct(Long id);
}
