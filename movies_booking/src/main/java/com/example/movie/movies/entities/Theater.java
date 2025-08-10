package com.example.movie.movies.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Theater {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @ManyToMany(mappedBy = "theaters")
    private Set<Movie> movies = new HashSet<>();

    public Theater() {}
    public Theater(String name, String location) { this.name = name; this.location = location; }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public Set<Movie> getMovies() { return movies; }
    public void setMovies(Set<Movie> movies) { this.movies = movies; }
}
