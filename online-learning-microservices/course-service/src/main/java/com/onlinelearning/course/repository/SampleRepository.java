package com.onlinelearning.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onlinelearning.course.entity.SampleEntity;

public interface SampleRepository extends JpaRepository<SampleEntity, Long> {
}
