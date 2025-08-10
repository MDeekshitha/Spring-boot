package com.example.movie.movies.dto;

import java.time.LocalDateTime;

public class BookingDTO {
    private Long id;
    private LocalDateTime bookingDate;
    private int seats;
    private Long movieId;
    private Long theaterId;
    private Long customerId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }
    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }
    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }
    public Long getTheaterId() { return theaterId; }
    public void setTheaterId(Long theaterId) { this.theaterId = theaterId; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
