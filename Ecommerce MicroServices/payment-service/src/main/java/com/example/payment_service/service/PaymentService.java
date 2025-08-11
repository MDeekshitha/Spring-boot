package com.example.payment_service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment_service.model.Payment;
import com.example.payment_service.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
    private PaymentRepository paymentRepository;
    
    public Payment createPayment(Long orderId, Double amount) {
//        Optional<Order> order = orderRepository.findById(orderId);
//        if (!order.isPresent()) {
//            throw new RuntimeException("Order not found");
//        }
//        
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setStatus("Completed");
        payment.setPaymentDate(LocalDateTime.now());

        return paymentRepository.save(payment);
    }
}
