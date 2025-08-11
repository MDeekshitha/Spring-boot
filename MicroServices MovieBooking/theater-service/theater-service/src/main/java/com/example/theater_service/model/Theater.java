package com.example.theater_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Theater {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
//    @ManyToMany(mappedBy = "theaters")
//    private List<Movie> movies = new ArrayList();
//
//	public List<Movie> getMovies() {
//		return movies;
//	}
//	public void setMovies(List<Movie> movies) {
//		this.movies = movies;
//	}
	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
//	 public void addMovie(Movie m) {
//	    	this.movies.add(m);
//	    	m.getTheaters().add(this);
//	    }
}

