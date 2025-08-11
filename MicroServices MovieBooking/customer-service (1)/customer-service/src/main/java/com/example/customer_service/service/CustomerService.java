package com.example.customer_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer_service.model.Customer;
import com.example.customer_service.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer c = customerRepository.save(customer);
		return c;
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).get();
	}

	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}
}