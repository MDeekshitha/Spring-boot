package com.example.movie.movies.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie.movies.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
