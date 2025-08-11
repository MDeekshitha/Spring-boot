package com.example.product_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_service.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByName(String name);

}