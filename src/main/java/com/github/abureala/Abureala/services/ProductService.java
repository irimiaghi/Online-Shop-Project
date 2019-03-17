package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> giveAllProducts();

    Product createProduct(String name, String priceBuy, String priceRent);

    void deleteProduct(long id);

    List<Optional<Product>> findByname(String name);

}
