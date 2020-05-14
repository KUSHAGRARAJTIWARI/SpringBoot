package com.example.Customers.Controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Customers.Exception.ResourceNotFoundException;
import com.example.Customers.Model.Customer;
import com.example.Customers.Repository.CustomerRepository;

@RestController
public class CustomersController {

	@Autowired
	private CustomerRepository customerRepository;
	
	//Get all Customers
	@GetMapping("/Customers")
	public List<Customer> getCustomers(){
		List<Customer> Customers=customerRepository.findAll();
		if(Customers.isEmpty()){
			throw new ResourceNotFoundException("No Customer Found.");
		}
		return Customers;
	}
	
	//Get Customers by Id
	@GetMapping("/Customers/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not found with Id: "+id));
	}
	
	//Create a new Customer
	@PostMapping("/Customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
		
	}
	
	
}
