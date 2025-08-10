package com.example.movie.movies.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;

import com.example.movie.movies.entities.Booking;
import com.example.movie.movies.services.BookingService;
import com.example.movie.movies.dto.CreateBookingRequest;
import com.example.movie.movies.dto.BookingDTO;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingDTO>> all() {
        List<BookingDTO> list = bookingService.findAll().stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(bookingService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<BookingDTO> create(@Valid @RequestBody CreateBookingRequest req) {
        Booking created = bookingService.createBooking(req);
        return ResponseEntity.status(201).body(toDto(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private BookingDTO toDto(Booking b) {
        BookingDTO dto = new BookingDTO();
        dto.setId(b.getId());
        dto.setBookingDate(b.getBookingDate());
        dto.setSeats(b.getSeats());
        dto.setMovieId(b.getMovie() != null ? b.getMovie().getId() : null);
        dto.setTheaterId(b.getTheater() != null ? b.getTheater().getId() : null);
        dto.setCustomerId(b.getCustomer() != null ? b.getCustomer().getId() : null);
        return dto;
    }
}
