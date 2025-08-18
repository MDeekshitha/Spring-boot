package com.example.assessment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assessment_service.model.Assessment;
@Repository
public interface AssessmentRepository extends JpaRepository<Assessment	,Long >{

}
