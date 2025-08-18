package com.onlinelearning.user.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.onlinelearning.user.entity.SampleEntity;
import com.onlinelearning.user.repository.SampleRepository;

@RestController
@RequestMapping("/api/user")
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
