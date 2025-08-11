package com.example.customer_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.customer_service.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{
	
	
	Customer findByEmail(String email);
	//Syntax - findByPropertyName(String name)
	//select c1_0.id,c1_0.email,c1_0.name,c1_0.password from customer c1_0 where c1_0.name=?
	Customer findByName(String nameStr);
	//select c1_0.id,c1_0.email,c1_0.name,c1_0.password from customer c1_0 where c1_0.name=? and c1_0.email=?
	Customer findByNameAndEmail(String nameStr, String emailStr);
	//select c1_0.id,c1_0.email,c1_0.name,c1_0.password from customer c1_0 where c1_0.name like ? escape '\\'
	//Syntax - findByPropertyNameStartsWith(String prefix)
	List<Customer> findByNameStartingWith(String prefix);
	//Syntax - countByPropertyNameStartsWith(String prefix)
	//select count(c1_0.id) from customer c1_0 where c1_0.name like ? escape '\\'
	long countByNameStartingWith(String prefix);
	
	//Custom Query - list of customers whose emails are ends with @gmail.com 
	//HQL - select c1_0.id,c1_0.email,c1_0.name,c1_0.password from customer c1_0 where c1_0.email like ? escape ''
	@Query("Select c FROM Customer c WHERE c.email LIKE %:domain") 
	List<Customer> findCustomersByEmailDomain(String domain);

	//select c1_0.id,c1_0.email,c1_0.name,c1_0.password from customer c1_0 where c1_0.email like ? escape ''
	
	//Native SQL - pure SQL query
	@Query(value="select * from customer where age = (select min(age) from customer)",nativeQuery = true)
	Customer findCustomerWithMinAge();
	

}