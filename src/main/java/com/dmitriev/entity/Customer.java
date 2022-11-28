package com.dmitriev.entity;

import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    List<Project> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
