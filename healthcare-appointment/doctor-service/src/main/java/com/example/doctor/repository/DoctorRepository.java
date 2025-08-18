package com.example.doctor.repository;
import com.example.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}