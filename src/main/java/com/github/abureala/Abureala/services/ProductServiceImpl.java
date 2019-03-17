package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.model.Product;
import com.github.abureala.Abureala.repositories.ProductRepository;
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

    @Override
    public Product createProduct(String name, String priceBuy, String priceRent) {
        Product product = new Product();

        product.setName(name);
        product.setPriceRent(priceRent);
        product.setPriceBuy(priceBuy);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByNameLike(String name) {
        List<Product> product = productRepository.findByNameIgnoreCaseContaining(name);
        return product;
    }

    @Override
    public void saveProducts(List<Product> list) {
        productRepository.saveAll(list);
    }
}
