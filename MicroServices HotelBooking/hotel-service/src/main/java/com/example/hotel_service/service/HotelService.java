package com.example.hotel_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_service.model.Hotel;
import com.example.hotel_service.repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	HotelRepository hotelRepository;

	public Hotel saveHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		Hotel h = hotelRepository.save(hotel);
		return h;
	}

	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	public Hotel getHotelById(Long id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).get();
	}

	public void deleteHotel(Long id) {
		// TODO Auto-generated method stub
		hotelRepository.deleteById(id);
	}

}
