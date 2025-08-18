package com.example.booking_service_MS.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.booking_service_MS.dto.DriverDTO;

@FeignClient(name="driver-service", url="http://localhost:1114")
public interface DriverClient {
	
	@GetMapping("/api/drivers/{driverId}")
	DriverDTO getProductById(@PathVariable Long id );

}