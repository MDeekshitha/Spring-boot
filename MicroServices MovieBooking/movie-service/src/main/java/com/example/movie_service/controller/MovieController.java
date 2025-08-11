package com.example.movie_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_service.model.Movie;
import com.example.movie_service.service.MovieService;


@RestController
@RequestMapping("/api/movies")
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@GetMapping
	public List<Movie> getAllMovie(){
		return movieService.getAllMovies();
	}

	@PostMapping
	public Movie createMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
		Movie movie = movieService.getMovieById(id);
		return  new ResponseEntity<Movie>(movie,HttpStatus.OK) ;
	}
	
	@PutMapping("/{id}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
		Movie existingMovie = movieService.getMovieById(id);
    	existingMovie.setTitle(movie.getTitle());
    	existingMovie.setGenre(movie.getGenre());
    	
    	Movie result = movieService.saveMovie(existingMovie);
    	
    	return result;
	}
	@DeleteMapping("/{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return "Movie deleted with this "+id;
	}

}
