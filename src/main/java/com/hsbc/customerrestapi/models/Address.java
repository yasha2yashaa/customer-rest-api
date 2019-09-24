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

    @Column(name = "ziCode", updatable = false, nullable = false)
    private String zipCode;

    @OneToMany(mappedBy = "father")
    @JsonIgnoreProperties({"father"})
    private Set<Customer> customers;
}
