package com.example.movie.movies.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.movie.movies.entities.*;
import com.example.movie.movies.repos.*;
import com.example.movie.movies.dto.CreateBookingRequest;
import com.example.movie.movies.exceptions.ResourceNotFoundException;

@Service
public class BookingService {
    @Autowired private BookingRepository bookingRepo;
    @Autowired private CustomerRepository customerRepo;
    @Autowired private MovieRepository movieRepo;
    @Autowired private TheaterRepository theaterRepo;

    public List<Booking> findAll() { return bookingRepo.findAll(); }

    public Booking findById(Long id) {
        return bookingRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Booking not found: " + id));
    }

    @Transactional
    public Booking createBooking(CreateBookingRequest req) {
        Customer customer = customerRepo.findById(req.getCustomerId())
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + req.getCustomerId()));
        Movie movie = movieRepo.findById(req.getMovieId())
            .orElseThrow(() -> new ResourceNotFoundException("Movie not found: " + req.getMovieId()));
        Theater theater = theaterRepo.findById(req.getTheaterId())
            .orElseThrow(() -> new ResourceNotFoundException("Theater not found: " + req.getTheaterId()));

        Booking b = new Booking();
        b.setCustomer(customer);
        b.setMovie(movie);
        b.setTheater(theater);
        b.setSeats(req.getSeats());
        b.setBookingDate(LocalDateTime.now());

        Booking saved = bookingRepo.save(b);
        customer.getBookings().add(saved);
        return saved;
    }

    public void delete(Long id) { bookingRepo.deleteById(id); }
}
