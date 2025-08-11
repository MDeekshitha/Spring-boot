package com.example.booking_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking_service.model.Booking;
import com.example.booking_service.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository bookingRepository;

	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		Booking b = bookingRepository.save(booking);
		return b;
	}

	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	public Booking getBookingById(Long id) {
		// TODO Auto-generated method stub
		return bookingRepository.findById(id).get();
	}

	public void deleteBooking(Long id) {
		// TODO Auto-generated method stub
		bookingRepository.deleteById(id);
	}
}
