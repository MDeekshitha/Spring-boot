package com.example.airline;

import java.util.HashMap;
import java.util.Map;

public class FlightService {
    private Map<String, Integer> flightSeats = new HashMap<>();

    public FlightService() {
        flightSeats.put("FL123", 2);
        flightSeats.put("FL456", 0);
    }

    public boolean isSeatAvailable(String flightId) {
        return flightSeats.containsKey(flightId) && flightSeats.get(flightId) > 0;
    }

    public void bookSeat(String flightId) {
        flightSeats.put(flightId, flightSeats.get(flightId) - 1);
    }
}
