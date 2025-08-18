package com.example.driver_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.driver_service.model.Driver;
import com.example.driver_service.repository.DriverRepository;

@Service
public class DriverService {
	@Autowired
	DriverRepository driverRepository;
	
	public List<Driver> getAllDrivers() {
		// TODO Auto-generated method stub
		return driverRepository.findAll();
	}

	public Driver saveDriver(Driver driver) {
		// TODO Auto-generated method stub
		Driver d = driverRepository.save(driver);
		return d;
	}

	public Driver getDriverById(Long id) {
		// TODO Auto-generated method stub
		Optional<Driver> driv = driverRepository.findById(id);
		if(driv.isPresent())
			return driverRepository.findById(id).get();
		return null;
	}

	public void deleteDriver(Long id) {
		// TODO Auto-generated method stub
		driverRepository.deleteById(id);
	}

}
