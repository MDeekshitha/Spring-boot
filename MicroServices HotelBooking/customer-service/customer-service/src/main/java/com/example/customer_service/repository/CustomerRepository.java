package com.example.customer_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer_service.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	Optional<Customer> findByEmail(String email);
}
