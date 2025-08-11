package com.example.booking_service.dto;

public class CustomerDTO {
	 private Long id;
	 private String name;
	 private String email;
	 private String password; // This will be encoded
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
	 public String getEmail() {
		 return email;
	 }
	 public void setEmail(String email) {
		 this.email = email;
	 }
	 public String getPassword() {
		 return password;
	 }
	 public void setPassword(String password) {
		 this.password = password;
	 }
	 public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	 }   
}
