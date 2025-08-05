package com.example.ecommerce_app_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_app_rest_api.model.Customer;



@Repository

public  interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
