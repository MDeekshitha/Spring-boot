package com.example.booking_service_MS.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.booking_service_MS.dto.VehicleDTO;

@FeignClient(name="vehicle-service", url="http://localhost:1112")
public interface VehicleClient {
	
	@GetMapping("/api/vehicles/{vehilceId}")
	VehicleDTO getProductById(@PathVariable Long id );

}