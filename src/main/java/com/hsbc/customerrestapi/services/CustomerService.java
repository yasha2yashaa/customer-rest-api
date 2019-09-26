package com.hsbc.customerrestapi.services;

import com.hsbc.customerrestapi.models.Customer;
import com.hsbc.customerrestapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements RestService<Customer>{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getById(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Iterable<Customer> getAll() {
        return customerRepository.findAll();
    }
}
