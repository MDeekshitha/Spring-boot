package com.example.vehicle_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicle_service.model.Vehicle;
import com.example.vehicle_service.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	@GetMapping
	public List<Vehicle> getAllCustomer() {
		return vehicleService.getAllVehicles();
	}

	@PostMapping
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.saveVehicle(vehicle);
	}
	@PutMapping("/{id}")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id) {
		Vehicle existingVehicle = vehicleService.getVehicleById(id);
		existingVehicle.setVehicleNumber(vehicle.getVehicleNumber());
		existingVehicle.setVehicleType(vehicle.getVehicleType());
		existingVehicle.setVehicleStatus(vehicle.getVehicleStatus());
		existingVehicle.setCapacity(vehicle.getCapacity());
		existingVehicle.setCreatedAt(vehicle.getCreatedAt());
		existingVehicle.setUpdatedAt(vehicle.getUpdatedAt());

		Vehicle result = vehicleService.saveVehicle(existingVehicle);

		return result;

	}

	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		vehicleService.deleteVehicle(id);
		return "Customer deleted with this " + id;
	}
}
