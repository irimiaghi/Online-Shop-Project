package com.github.abureala.Abureala.config.services;

import com.github.abureala.Abureala.config.model.Product;
import com.github.abureala.Abureala.config.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> giveAllProducts() {
        return productRepository.findAll();
    }
}
