package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.model.Product;
import com.github.abureala.Abureala.repositories.ProductPricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductPricingImpl implements ProductPricingService {
    @Autowired
    private ProductPricingRepository productPricingRepository;

    @Override
    public Optional<Product> getProductById(Long id) {
        return productPricingRepository.findById(id);
    }

    @Override
    public Optional<String> getProductName(Long id) {
        Optional<Product> product = productPricingRepository.findById(id);
        return product.map(Product::getName);
    }

    @Override
    public Optional<String> getProductBuyPrice(Long id) {
        Optional<Product> product = productPricingRepository.findById(id);
        return product.map(Product::getPriceBuy);
    }

    @Override
    public Optional<String> getProductRentPrice(Long id) {
        Optional<Product> product = productPricingRepository.findById(id);
        return product.map(Product::getPriceRent);
    }

    @Override
    public Product createProduct(String name, String price_buy, String price_rent) {
        Product product = new Product();
        product.setName(name);
        product.setPriceBuy(price_buy);
        product.setPriceRent(price_rent);
        return productPricingRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {

    }
}