package com.example.theater_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_service.model.Theater;
import com.example.theater_service.repository.TheaterRepository;

@Service
public class TheaterService {
	@Autowired
	TheaterRepository theaterRepository;

	public Theater saveTheater(Theater theater) {
		// TODO Auto-generated method stub
		Theater m = theaterRepository.save(theater);
		return m;
	}

	public List<Theater> getAllTheaters() {
		// TODO Auto-generated method stub
		return theaterRepository.findAll();
	}

	public Theater getTheaterById(Long id) {
		// TODO Auto-generated method stub
		return theaterRepository.findById(id).get();
	}

	public void deleteTheater(Long id) {
		// TODO Auto-generated method stub
		theaterRepository.deleteById(id);
	}
}
