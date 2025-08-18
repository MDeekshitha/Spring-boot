package com.example.vehicle_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vehicle_service.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long>{
	
}
