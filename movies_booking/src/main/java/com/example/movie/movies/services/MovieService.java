package com.example.movie.movies.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.movie.movies.entities.Movie;
import com.example.movie.movies.repos.MovieRepository;
import com.example.movie.movies.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepo;

    public List<Movie> findAll() { return movieRepo.findAll(); }
    public Movie findById(Long id) {
        return movieRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found: " + id));
    }
    public Movie save(Movie m) { return movieRepo.save(m); }
    public Movie update(Long id, Movie updated) {
        Movie existing = findById(id);
        existing.setTitle(updated.getTitle());
        existing.setGenre(updated.getGenre());
        return movieRepo.save(existing);
    }
    public void delete(Long id) { movieRepo.deleteById(id); }
}
