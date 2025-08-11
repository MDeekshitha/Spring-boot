package com.transportation.routeservice.controller;

import com.transportation.routeservice.model.Route;
import com.transportation.routeservice.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
    @Autowired
    private RouteRepository routeRepository;

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Route> getRouteById(@PathVariable Long id) {
        return routeRepository.findById(id);
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route) {
        route.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        route.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return routeRepository.save(route);
    }
}
