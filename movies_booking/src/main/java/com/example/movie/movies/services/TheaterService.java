package com.example.movie.movies.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.movie.movies.entities.Theater;
import com.example.movie.movies.repos.TheaterRepository;
import com.example.movie.movies.exceptions.ResourceNotFoundException;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepo;

    public List<Theater> findAll() { return theaterRepo.findAll(); }
    public Theater findById(Long id) {
        return theaterRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theater not found: " + id));
    }
    public Theater save(Theater t) { return theaterRepo.save(t); }
    public Theater update(Long id, Theater updated) {
        Theater existing = findById(id);
        existing.setName(updated.getName());
        existing.setLocation(updated.getLocation());
        return theaterRepo.save(existing);
    }
    public void delete(Long id) { theaterRepo.deleteById(id); }
}
