package com.example.booking_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booking_service.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long>{
	List<Booking> findByCustomerId(Long customerId);
	List<Booking> findByRoomId(Long roomId);
}
