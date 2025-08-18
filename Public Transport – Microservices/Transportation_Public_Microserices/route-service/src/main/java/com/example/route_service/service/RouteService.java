package com.example.route_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.route_service.model.Route;
import com.example.route_service.repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
	RouteRepository routeRepository;
	
	public List<Route> getAllVehicles() {
		// TODO Auto-generated method stub
		return routeRepository.findAll();
	}

	public Route saveRoute(Route route) {
		// TODO Auto-generated method stub
		Route r = routeRepository.save(route);
		return r;
	}

	public Route getRouteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Route> vehi = routeRepository.findById(id);
		if(vehi.isPresent())
			return routeRepository.findById(id).get();
		return null;
	}

	public void deleteRoute(Long id) {
		// TODO Auto-generated method stub
		routeRepository.deleteById(id);
	}

}
