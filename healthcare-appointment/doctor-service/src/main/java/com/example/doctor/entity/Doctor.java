package com.example.doctor.entity;

import jakarta.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialization;

    private String contact;

    // Example: Monday, Tuesday, etc.
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<DayOfWeek> availableDays;

    // Example: 09:00 - 17:00 availability
    private LocalTime startTime;

    private LocalTime endTime;

    public Doctor() {
    }

    public Doctor(String name, String specialization, String contact,
                  List<DayOfWeek> availableDays, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.specialization = specialization;
        this.contact = contact;
        this.availableDays = availableDays;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }

    public List<DayOfWeek> getAvailableDays() { return availableDays; }

    public void setAvailableDays(List<DayOfWeek> availableDays) { this.availableDays = availableDays; }

    public LocalTime getStartTime() { return startTime; }

    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }

    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
}
