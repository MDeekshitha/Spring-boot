package com.transportation.driverservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;
    private String name;
    private String licenseNumber;
    private String phone;
    @Enumerated(EnumType.STRING)
    private DriverStatus status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public enum DriverStatus { AVAILABLE, ON_TRIP, OFF_DUTY }
}
