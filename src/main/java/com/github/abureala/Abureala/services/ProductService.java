package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProductService {

    List<Product> giveAllProducts();
}
