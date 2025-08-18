package com.example.vehicle_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehicle_service.model.Vehicle;
import com.example.vehicle_service.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<Vehicle> getAllVehicles() {
		// TODO Auto-generated method stub
		return vehicleRepository.findAll();
	}

	public Vehicle saveVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		Vehicle v = vehicleRepository.save(vehicle);
		return v;
	}

	public Vehicle getVehicleById(Long id) {
		// TODO Auto-generated method stub
		Optional<Vehicle> vehi = vehicleRepository.findById(id);
		if(vehi.isPresent())
			return vehicleRepository.findById(id).get();
		return null;
	}

	public void deleteVehicle(Long id) {
		// TODO Auto-generated method stub
		vehicleRepository.deleteById(id);
	}

}
