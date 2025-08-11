package com.example.customer_service.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer_service.model.Customer;
import com.example.customer_service.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
		Customer customer = customerService.getCustomerById(id);
		return  new ResponseEntity<Customer>(customer,HttpStatus.OK) ;
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		Customer existingCustomer = customerService.getCustomerById(id);
    	existingCustomer.setName(customer.getName());
    	existingCustomer.setPassword(customer.getPassword());
    	existingCustomer.setEmail(customer.getEmail());
    	
    	Customer result = customerService.saveCustomer(existingCustomer);
    	
    	return result;
    	
	}
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return "Customer deleted with this "+id;
	}
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Customer customer) {
	    return ResponseEntity.ok(customerService.registerCustomer(customer));
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String email,@RequestParam String password) {
		return ResponseEntity.ok(customerService.loginCustomer(email, password));
	}
}