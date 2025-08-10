package com.example.movie.movies.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie.movies.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {}
