package com.example.airline;

public class TicketService {
    private FlightService flightService;

    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    public String confirmBooking(String flightId, String userId) {
        if (flightService.isSeatAvailable(flightId)) {
            flightService.bookSeat(flightId);
            return "Booking confirmed for " + userId + " on " + flightId;
        }
        return "Flight " + flightId + " is full";
    }
}
