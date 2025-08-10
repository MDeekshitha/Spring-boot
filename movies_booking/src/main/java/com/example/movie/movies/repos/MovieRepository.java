package com.example.movie.movies.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie.movies.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {}
