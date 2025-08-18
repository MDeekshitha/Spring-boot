package com.onlinelearning.course.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.onlinelearning.course.entity.SampleEntity;
import com.onlinelearning.course.repository.SampleRepository;

@RestController
@RequestMapping("/api/course")
public class SampleController {
    private final SampleRepository repository;

    public SampleController(SampleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SampleEntity> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public SampleEntity create(@RequestBody SampleEntity entity) {
        return repository.save(entity);
    }
}
