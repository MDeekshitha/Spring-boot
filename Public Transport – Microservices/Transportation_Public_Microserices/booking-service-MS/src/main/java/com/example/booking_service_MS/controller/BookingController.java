package com.example.booking_service_MS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking_service_MS.model.Booking;
import com.example.booking_service_MS.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	@Autowired
	BookingService bookingService;

	@PostMapping
	public Booking createBooking(@RequestBody Booking booking) {
		return bookingService.saveBooking(booking);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
		Booking booking = bookingService.getBookingById(id);
	    	return ResponseEntity.ok(booking);
	}

	@GetMapping
	public ResponseEntity<List<Booking>> getAllBooking() {
		return ResponseEntity.ok(bookingService.getAllBookings());
	}
	
	@PutMapping("/{id}")
	public Booking updateBooking(@RequestBody Booking booking, @PathVariable Long id) {
		Booking existingBooking = bookingService.getBookingById(id);
		existingBooking.setCustomerName(booking.getCustomerName());
		existingBooking.setContactNumber(booking.getContactNumber());
		existingBooking.setRouteId(booking.getRouteId());
		existingBooking.setDriverId(booking.getDriverId());
		existingBooking.setVehicleId(booking.getVehicleId());
		existingBooking.setBookingStatus(booking.getBookingStatus());

		Booking result = bookingService.saveBooking(existingBooking);

		return result;

	}

	@DeleteMapping("/{id}")
	public String deleteBooking(@PathVariable Long id) {
		bookingService.deleteBooking(id);
		return "Booking deleted with this " + id;
	}
}
