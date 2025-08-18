package com.example.booking_service_MS.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.booking_service_MS.dto.RouteDTO;

@FeignClient(name="route-service", url="http://localhost:1113")
public interface RouteClient {
	
	@GetMapping("/api/routes/{routeId}")
	RouteDTO getRouteById(@PathVariable Long id );

}