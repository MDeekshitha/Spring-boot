package com.example.patient.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")   // optional, but recommended
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String insurance;
    private String contact;

    // ✅ Constructors
    public Patient() {}

    public Patient(String name, String insurance, String contact) {
        this.name = name;
        this.insurance = insurance;
        this.contact = contact;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}


