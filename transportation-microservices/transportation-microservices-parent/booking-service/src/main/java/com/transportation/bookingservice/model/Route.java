package com.transportation.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    private Long routeId;
    private String origin;
    private String destination;
    private Integer distanceKm;
}
