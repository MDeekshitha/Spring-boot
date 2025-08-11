package com.example.room_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.room_service.dto.HotelDTO;


@FeignClient(name="hotel-service", url="http://localhost:2001")
public interface HotelClient {
	@GetMapping("/api/hotels/{hotelId}/rooms")
	HotelDTO getAllRoomsById(@PathVariable Long id );
}