package com.hsbc.customerrestapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
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
}
