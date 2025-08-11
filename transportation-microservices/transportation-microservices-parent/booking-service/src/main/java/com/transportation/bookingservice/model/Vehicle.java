package com.transportation.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private Long vehicleId;
    private String vehicleNumber;
    private String type;
    private Integer capacity;
    private String status;
}
