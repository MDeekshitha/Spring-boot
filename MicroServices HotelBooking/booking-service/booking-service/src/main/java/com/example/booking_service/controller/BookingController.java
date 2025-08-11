package com.example.booking_service.controller;

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

import com.example.booking_service.model.Booking;
import com.example.booking_service.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	@GetMapping
	public List<Booking> getAllBooking(){
		return bookingService.getAllBookings();
	}

	@PostMapping
	public Booking createBooking(@RequestBody Booking booking) {
		return bookingService.saveBooking(booking);
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
		Booking booking = bookingService.getBookingById(id);
		return  new ResponseEntity<Booking>(booking,HttpStatus.OK) ;
	}
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Booking> getBookingBycustomerId(@PathVariable Long customerId){
		Booking booking = bookingService.getBookingBycustomerId(customerId);
		return  new ResponseEntity<Booking>(booking,HttpStatus.OK) ;
	}
	
	@PutMapping("/{id}")
	public Booking updateBooking(@RequestBody Booking booking, @PathVariable Long id) {
		Booking existingBooking = bookingService.getBookingById(id);
    	existingBooking.setCheckInDate(booking.getCheckInDate());
    	existingBooking.setCheckOutDate(booking.getCheckOutDate());
    	
    	Booking result = bookingService.saveBooking(existingBooking);
    	
    	return result;
	}
	@DeleteMapping("/{id}")
	public String deleteBooking(@PathVariable Long id) {
		bookingService.deleteBooking(id);
		return "Booking deleted with this "+id;
	}
}
