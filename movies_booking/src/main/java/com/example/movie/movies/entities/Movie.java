package com.example.movie.movies.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;

    @ManyToMany
    @JoinTable(
        name = "movie_theater",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "theater_id")
    )
    private Set<Theater> theaters = new HashSet<>();

    public Movie() {}
    public Movie(String title, String genre) { this.title = title; this.genre = genre; }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public Set<Theater> getTheaters() { return theaters; }
    public void setTheaters(Set<Theater> theaters) { this.theaters = theaters; }
}
