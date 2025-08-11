package com.example.room_service.dto;

public class HotelDTO {
	private Long id;
    private String name;
    private String location;
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
	public HotelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
