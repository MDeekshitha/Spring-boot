package com.transportation.vehicleservice.controller;

import com.transportation.vehicleservice.model.Vehicle;
import com.transportation.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleRepository.findById(id);
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        vehicle.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        vehicle.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return vehicleRepository.save(vehicle);
    }
}
