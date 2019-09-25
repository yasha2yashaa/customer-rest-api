package com.hsbc.customerrestapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name", updatable = false, nullable = false)
    private String name;

    @ManyToOne
    @JsonIgnoreProperties({"customers"})
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Address address;

    // Default Constructor
    public Customer() {}

    // Constructor for testing
    public Customer(String name, Address address) {
        this.setName(name);
        this.setAddress(address);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
