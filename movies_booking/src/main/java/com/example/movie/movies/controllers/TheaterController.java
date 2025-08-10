package com.example.movie.movies.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.movie.movies.entities.Theater;
import com.example.movie.movies.services.TheaterService;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public ResponseEntity<List<Theater>> all() { return ResponseEntity.ok(theaterService.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> get(@PathVariable Long id) { return ResponseEntity.ok(theaterService.findById(id)); }

    @PostMapping
    public ResponseEntity<Theater> create(@RequestBody Theater theater) {
        return ResponseEntity.status(201).body(theaterService.save(theater));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theater> update(@PathVariable Long id, @RequestBody Theater theater) {
        return ResponseEntity.ok(theaterService.update(id, theater));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        theaterService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
