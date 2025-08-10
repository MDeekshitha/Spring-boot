package com.example.movie.movies.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie.movies.entities.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {}
