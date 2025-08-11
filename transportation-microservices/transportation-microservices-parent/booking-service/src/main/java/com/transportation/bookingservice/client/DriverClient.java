package com.transportation.bookingservice.client;

import com.transportation.bookingservice.model.Driver;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "driver-service")
public interface DriverClient {
    @GetMapping("/api/drivers/{id}")
    @CircuitBreaker(name = "driver-service", fallbackMethod = "getDriverFallback")
    Optional<Driver> getDriverById(@PathVariable("id") Long id);

    default Optional<Driver> getDriverFallback(Long id, Throwable t) {
        System.err.println("Fallback triggered for getDriverById: " + t.getMessage());
        return Optional.empty();
    }
}
