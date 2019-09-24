package com.hsbc.customerrestapi.repositories;

import com.hsbc.customerrestapi.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
