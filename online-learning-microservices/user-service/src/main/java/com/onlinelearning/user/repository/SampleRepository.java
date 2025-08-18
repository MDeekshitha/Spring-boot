package com.onlinelearning.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onlinelearning.user.entity.SampleEntity;

public interface SampleRepository extends JpaRepository<SampleEntity, Long> {
}
