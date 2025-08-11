package com.transportation.bookingservice.client;

import com.transportation.bookingservice.model.Vehicle;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "vehicle-service")
public interface VehicleClient {
    @GetMapping("/api/vehicles/{id}")
    @CircuitBreaker(name = "vehicle-service", fallbackMethod = "getVehicleFallback")
    Optional<Vehicle> getVehicleById(@PathVariable("id") Long id);

    default Optional<Vehicle> getVehicleFallback(Long id, Throwable t) {
        System.err.println("Fallback triggered for getVehicleById: " + t.getMessage());
        return Optional.empty();
    }
}
