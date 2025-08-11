package com.example.order_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	 public Order createOrder(Long customerId){
//	        Customer customer = customerService.getCustomerById(customerId);
//	        if (customer == null) {
//	            throw new RuntimeException("Customer not found");
//	        }
//	        
	        Order order = new Order();
	        order.setOrderDate(LocalDateTime.now());
//	        order.setCustomer(customer);
//	        
	        
	        return orderRepository.save(order);
	    }
	 
	 public Order createOrderWithProducts(Long customerId, List<Long> productIds) {
//	        Customer customer = customerService.getCustomerByEmail("vikas@hotmail.com");
//	        if (customer == null) {
//	            throw new RuntimeException("Customer not found");
//	        }
	        Order order = new Order();
//	        
//	        List<Product> products = productIds.stream()
//	                .map(productId ->{
//	                	Product p = productService.getProductById(productId).get();
//	                	//relation set -> fill your join table
//	                	order.addProduct(p);
//	                	return p;
//	                })
//	                .collect(Collectors.toList());
//	        
//	        
//	        order.setCustomer(customer);
//	      //relation set -> fill your join table
//	        order.setProducts(products);
//	        order.setOrderDate(LocalDateTime.now());

	        return orderRepository.save(order);
	    }
}
