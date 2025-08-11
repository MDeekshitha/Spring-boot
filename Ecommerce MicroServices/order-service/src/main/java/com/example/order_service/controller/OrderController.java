package com.example.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.order_service.model.Order;
import com.example.order_service.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam Long customerId){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(customerId));
    }
}
