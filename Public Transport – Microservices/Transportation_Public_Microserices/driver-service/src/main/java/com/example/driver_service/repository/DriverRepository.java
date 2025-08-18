package com.example.driver_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.driver_service.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long>{

}
