package com.example.movie.movies.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreateBookingRequest {
    @NotNull
    private Long customerId;
    @NotNull
    private Long movieId;
    @NotNull
    private Long theaterId;
    @Min(1)
    private int seats;

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }
    public Long getTheaterId() { return theaterId; }
    public void setTheaterId(Long theaterId) { this.theaterId = theaterId; }
    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }
}
