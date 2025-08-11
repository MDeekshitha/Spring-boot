package com.transportation.vehicleservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    @Column(unique = true)
    private String vehicleNumber;
    @Enumerated(EnumType.STRING)
    private VehicleType type;
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    private VehicleStatus status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public enum VehicleType { BUS, CAR, VAN, TRUCK }
    public enum VehicleStatus { AVAILABLE, ON_TRIP, MAINTENANCE }
}
