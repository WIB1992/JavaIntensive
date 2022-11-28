package com.dmitriev.entity;

import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "position_name")
    @NotEmpty
    private String positionName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
    private List<Employee> employeeList;

    public Position() {
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Position(String positionName) {
        this.positionName = positionName;
    }
}
