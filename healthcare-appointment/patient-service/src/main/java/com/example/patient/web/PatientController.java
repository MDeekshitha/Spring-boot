package com.example.patient.web;

import com.example.patient.entity.Patient;
import com.example.patient.repo.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientRepository repo;
    public PatientController(PatientRepository repo) { this.repo = repo; }

    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody @Validated Patient p){
        return ResponseEntity.ok(repo.save(p));
    }

    @GetMapping
    public List<Patient> all(){ return repo.findAll(); }

    @GetMapping("{id}")
    public ResponseEntity<Patient> one(@PathVariable Long id){
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
