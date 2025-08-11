package com.example.theater_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.theater_service.model.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Long>{

}
