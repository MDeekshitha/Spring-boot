package com.example.doctor.controller;
import com.example.doctor.entity.Doctor;
import com.example.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")

public class DoctorController {


	    @Autowired
	    private DoctorRepository doctorRepository;

	    // Create Doctor
	    @PostMapping
	    public Doctor createDoctor(@RequestBody Doctor doctor) {
	        return doctorRepository.save(doctor);
	    }

	    // Get all Doctors
	    @GetMapping
	    public List<Doctor> getAllDoctors() {
	        return doctorRepository.findAll();
	    }

	    // Get Doctor by ID
	    @GetMapping("/{id}")
	    public Doctor getDoctorById(@PathVariable Long id) {
	        return doctorRepository.findById(id).orElse(null);
	    }
	}


