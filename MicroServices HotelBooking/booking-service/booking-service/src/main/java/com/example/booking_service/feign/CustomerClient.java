package com.example.booking_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.booking_service.dto.CustomerDTO;

@FeignClient(name="customer-service", url="http://localhost:2003")
public interface CustomerClient {
	@GetMapping("/api/customers/{id}")
	CustomerDTO getCustomerById(@PathVariable Long id );
}
