package com.example.route_service.controller;

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

import com.example.route_service.model.Route;
import com.example.route_service.service.RouteService;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
	@Autowired
	RouteService routeService;
	
	@GetMapping
	public ResponseEntity<List<Route>> getAllRoute() {
		return ResponseEntity.ok(routeService.getAllVehicles());
	}

	@PostMapping
	public Route createRoute(@RequestBody Route route) {
		return routeService.saveRoute(route);
	}
	@PutMapping("/{id}")
	public Route updateRoute(@RequestBody Route route, @PathVariable Long id) {
		Route existingRoute = routeService.getRouteById(id);
		existingRoute.setDestination(route.getDestination());
		existingRoute.setDistanceKm(route.getDistanceKm());
		existingRoute.setEstimatedDurationMin(route.getEstimatedDurationMin());
		existingRoute.setSource(route.getSource());
		existingRoute.setStops(route.getStops());
		existingRoute.setCreatedAt(route.getCreatedAt());
		existingRoute.setUpdatedAt(route.getUpdatedAt());

		Route result = routeService.saveRoute(existingRoute);

		return result;

	}

	@DeleteMapping("/{id}")
	public String deleteRoute(@PathVariable Long id) {
		routeService.deleteRoute(id);
		return "Route deleted with this " + id;
	}

}
