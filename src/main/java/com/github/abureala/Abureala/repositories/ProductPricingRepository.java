package com.github.abureala.Abureala.repositories;

import com.github.abureala.Abureala.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductPricingRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
