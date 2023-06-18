package com.winson.studentsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Model creates all the entities, getters, setters, and constructors

@Entity
public class Student {
    // Id annotation makes this the primary key
    @Id
    // This will make the ID autoincremented
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Attributes
    private int id;
    private String name;
    private String address;


    // constructor
    public Student() {

    }

    // Getters and Setters

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

