package com.example.movie_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String title;
	    private String genre;
//	    @ManyToMany
//	    @JoinTable(
//	      name = "movie_theater", 
//	      joinColumns = @JoinColumn(name = "movie_id"), 
//	      inverseJoinColumns = @JoinColumn(name = "theater_id"))
//	    private List<Theater> theaters;

	    
		public Movie() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		@Override
		public String toString() {
			return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + "]";
		}
//		public List<Theater> getTheaters() {
//			return theaters;
//		}
//		public void setTheaters(List<Theater> theaters) {
//			this.theaters = theaters;
//		}
}
