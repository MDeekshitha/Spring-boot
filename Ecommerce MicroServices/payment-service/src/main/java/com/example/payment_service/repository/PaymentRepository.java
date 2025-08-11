package com.example.payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payment_service.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>{

}
