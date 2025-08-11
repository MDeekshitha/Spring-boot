package com.example.hotel_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel_service.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long>{

}
