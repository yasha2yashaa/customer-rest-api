package com.hsbc.customerrestapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "city", updatable = false, nullable = false)
    private String city;

    @Column(name = "street", updatable = false, nullable = false)
    private String street;

    @Column(name = "zipCode", updatable = false, nullable = false)
    private String zipCode;

    @OneToMany(mappedBy = "address")
    @JsonIgnoreProperties({"address"})
    private Set<Customer> customers;

    // Default constructor
    public Address() {}

    // Constructor for testing
    public Address(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }
}
