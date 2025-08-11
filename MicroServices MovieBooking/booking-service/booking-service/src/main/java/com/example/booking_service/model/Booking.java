package com.example.booking_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookingDate;
    private int seats;
//    @ManyToOne
//    @JoinColumn(name = "movie_id")
//    private Movie movie;
//
//	@ManyToOne
//    @JoinColumn(name = "theater_id")
//    private Theater theater;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//    
//    public Movie getMovie() {
//		return movie;
//	}
//	public void setMovie(Movie movie) {
//		this.movie = movie;
//	}
//	public Theater getTheater() {
//		return theater;
//	}
//	public void setTheater(Theater theater) {
//		this.theater = theater;
//	}
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingDate=" + bookingDate + ", seats=" + seats + "]";
	}
}
