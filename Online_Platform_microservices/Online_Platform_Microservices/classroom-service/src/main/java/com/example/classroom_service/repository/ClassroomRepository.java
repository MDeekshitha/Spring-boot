package com.example.classroom_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.classroom_service.model.Classroom;
@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
