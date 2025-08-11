package com.example.booking_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.booking_service.dto.CustomerDTO;
import com.example.booking_service.feign.CustomerClient;
import com.example.booking_service.model.Booking;
import com.example.booking_service.repository.BookingRepository;


@Service
public class BookingService {
	
	private static final String CUSTOMER_SERVICE_URL = "http://localhost:2003/api/customers";
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CustomerClient customerClient;
	
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

	public Booking getBookingBycustomerId(Long id) {
		CustomerDTO customer = customerClient.getCustomerById(id);
		// TODO Auto-generated method stub
		Booking booking = new Booking();
		booking.setCustomerId(customer.getId());
		booking.setCheckInDate(booking.getCheckInDate());
		booking.setCheckOutDate(booking.getCheckOutDate());
		bookingRepository.save(booking);
		return booking;
	}
	public CustomerDTO getCustomerDetails(Long customerId) {

		// http://localhost:2222/api/customers/1
		return restTemplate.getForObject(CUSTOMER_SERVICE_URL + "/" + customerId, CustomerDTO.class);
	}
	public Booking createBooking(Long customerId) {

		Booking booking = new Booking();
		booking.setCustomerId(customerId);

		return bookingRepository.save(booking);
	}

	public String placeBooking(Long customerId) {

		CustomerDTO customer = getCustomerDetails(customerId);
		if (customer != null) {
			Booking booking=new Booking();
			booking.setCustomerId(customer.getId());

			bookingRepository.save(booking);

		}
		return "Booking placed for Customer: " + customer.getName();
	}
}
