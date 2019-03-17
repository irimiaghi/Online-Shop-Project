package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> giveAllProducts();

    Product createProduct(String name, String priceBuy, String priceRent);

    void deleteProduct(long id);

    List<Product> findAllByNameLike(String name);

    void saveProducts(List<Product> list);

}
