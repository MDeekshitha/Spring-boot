package com.example.route_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.route_service.model.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long>{

}
