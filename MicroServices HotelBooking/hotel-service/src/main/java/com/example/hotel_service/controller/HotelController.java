package com.example.hotel_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_service.model.Hotel;
import com.example.hotel_service.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@GetMapping
	public List<Hotel> getAllHotels(){
		return hotelService.getAllHotels();
	}

	@PostMapping
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
		Hotel hotel = hotelService.getHotelById(id);
		return  new ResponseEntity<Hotel>(hotel,HttpStatus.OK) ;
	}
	
	@PutMapping("/{id}")
	public Hotel updateHotel(@RequestBody Hotel hotel, @PathVariable Long id) {
		Hotel existingHotel = hotelService.getHotelById(id);
    	existingHotel.setName(hotel.getName());
    	existingHotel.setLocation(hotel.getLocation());
    	
    	Hotel result = hotelService.saveHotel(existingHotel);
    	
    	return result;
    	
	}
	@DeleteMapping("/{id}")
	public String deleteHotel(@PathVariable Long id) {
		hotelService.deleteHotel(id);
		return "Customer deleted with this "+id;
	}
}
