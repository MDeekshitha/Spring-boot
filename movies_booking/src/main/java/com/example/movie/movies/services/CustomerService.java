package com.example.movie.movies.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.movie.movies.entities.Customer;
import com.example.movie.movies.repos.CustomerRepository;
import com.example.movie.movies.exceptions.ResourceNotFoundException;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> findAll() { return customerRepo.findAll(); }
    public Customer findById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));
    }
    public Customer save(Customer c) { return customerRepo.save(c); }
    public Customer update(Long id, Customer updated) {
        Customer existing = findById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        return customerRepo.save(existing);
    }
    public void delete(Long id) { customerRepo.deleteById(id); }
}
