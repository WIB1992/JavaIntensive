package com.dmitriev.entity;

import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "project_name")
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Customer customer;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
