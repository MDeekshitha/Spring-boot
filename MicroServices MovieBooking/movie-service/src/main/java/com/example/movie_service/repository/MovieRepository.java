package com.example.movie_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie_service.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{

}
