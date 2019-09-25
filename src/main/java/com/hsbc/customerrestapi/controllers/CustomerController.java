package com.hsbc.customerrestapi.controllers;

import com.hsbc.customerrestapi.models.Customer;
import com.hsbc.customerrestapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController implements Controller<Customer> {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer add(@RequestBody Customer customer) {
        customerService.add(customer);
        return customer;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getById(@PathVariable("id") long id) {
        return customerService.getById(id);
    }
}
