package com.transportation.driverservice.controller;

import com.transportation.driverservice.model.Driver;
import com.transportation.driverservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Driver> getDriverById(@PathVariable Long id) {
        return driverRepository.findById(id);
    }

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        driver.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        driver.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return driverRepository.save(driver);
    }
}
