package com.github.abureala.Abureala.repositories;

import com.github.abureala.Abureala.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameIgnoreCaseContaining(String name);
}
