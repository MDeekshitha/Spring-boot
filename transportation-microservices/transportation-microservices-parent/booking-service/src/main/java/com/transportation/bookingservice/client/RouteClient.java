package com.transportation.bookingservice.client;

import com.transportation.bookingservice.model.Route;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "route-service")
public interface RouteClient {
    @GetMapping("/api/routes/{id}")
    @CircuitBreaker(name = "route-service", fallbackMethod = "getRouteFallback")
    Optional<Route> getRouteById(@PathVariable("id") Long id);

    default Optional<Route> getRouteFallback(Long id, Throwable t) {
        System.err.println("Fallback triggered for getRouteById: " + t.getMessage());
        return Optional.empty();
    }
}
