package com.transportation.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    private Long driverId;
    private String name;
    private String licenseNumber;
    private String phone;
    private String status;
}
