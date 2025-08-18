package com.example.driver_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.driver_service.model.Driver;
import com.example.driver_service.service.DriverService;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
	@Autowired
	DriverService driverService;
	
	@GetMapping
	public ResponseEntity<List<Driver>> getAllDriver() {
		return ResponseEntity.ok(driverService.getAllDrivers());
	}

	@PostMapping
	public Driver createDriver(@RequestBody Driver driver) {
		return driverService.saveDriver(driver);
	}
	@PutMapping("/{id}")
	public Driver updateDriver(@RequestBody Driver driver, @PathVariable Long id) {
		Driver existingDriver = driverService.getDriverById(id);
		existingDriver.setName(driver.getName());
		existingDriver.setPhoneNumber(driver.getPhoneNumber());
		existingDriver.setLicenseNumber(driver.getLicenseNumber());
		existingDriver.setAvailabilityStatus(driver.getAvailabilityStatus());
		existingDriver.setVehicleId(driver.getVehicleId());
		existingDriver.setCreatedAt(driver.getCreatedAt());
		existingDriver.setUpdatedAt(driver.getUpdatedAt());

		Driver result = driverService.saveDriver(existingDriver);

		return result;

	}

	@DeleteMapping("/{id}")
	public String deleteDriver(@PathVariable Long id) {
		driverService.deleteDriver(id);
		return "Driver deleted with this " + id;
	}

}
