package com.example.movie_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_service.model.Movie;
import com.example.movie_service.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
//	
//	@Autowired
//	private CustomerService customerService;
//	
//	@Autowired
//	private TheaterService theaterService;

	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie m = movieRepository.save(movie);
		return m;
	}

	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	public Movie getMovieById(Long id) {
		// TODO Auto-generated method stub
		return movieRepository.findById(id).get();
	}

	public void deleteMovie(Long id) {
		// TODO Auto-generated method stub
		movieRepository.deleteById(id);
	}
//	public Movie createMovieWithTheaters(Long customerId, List<Long> theaterIds) {
//        Customer customer = customerService.getCustomerById(2);
//        if (customer == null) {
//            throw new RuntimeException("Customer not found");
//        }
//        Movie order = new Movie();
//        
//        List<Theater> theater = theaterIds.stream()
//                .map(theaterId ->{
//                	Theater p = theaterService.getTheaterById(theaterId).get();
//                	//relation set -> fill your join table
//                	order.addTheater(p);
//                	return p;
//                })
//                .collect(Collectors.toList());
//        
//        
//        order.setCustomer(customer);
//      //relation set -> fill your join table
//        order.setProducts(products);
//        order.setOrderDate(LocalDateTime.now());
//
//        return orderRepository.save(order);
//    }
}
