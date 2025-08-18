package com.onlinelearning.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onlinelearning.assessment.entity.SampleEntity;

public interface SampleRepository extends JpaRepository<SampleEntity, Long> {
}
