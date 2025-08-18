package com.example.booking_service_MS.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booking_service_MS.dto.DriverDTO;
import com.example.booking_service_MS.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long>{

	Optional<Booking> findBookingByVehicleId(Long id);

	void save(DriverDTO driver);

}
