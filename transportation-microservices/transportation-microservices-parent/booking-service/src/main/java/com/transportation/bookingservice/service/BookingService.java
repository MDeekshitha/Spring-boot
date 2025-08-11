package com.transportation.bookingservice.service;

import com.transportation.bookingservice.client.DriverClient;
import com.transportation.bookingservice.client.RouteClient;
import com.transportation.bookingservice.client.VehicleClient;
import com.transportation.bookingservice.model.Booking;
import com.transportation.bookingservice.model.Driver;
import com.transportation.bookingservice.model.Route;
import com.transportation.bookingservice.model.Vehicle;
import com.transportation.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private VehicleClient vehicleClient;
    @Autowired
    private DriverClient driverClient;
    @Autowired
    private RouteClient routeClient;

    public Booking createBooking(Booking booking) {
        // Step 1: Check availability of vehicle, driver, and route via Feign clients
        Optional<Vehicle> vehicle = vehicleClient.getVehicleById(booking.getVehicleId());
        Optional<Driver> driver = driverClient.getDriverById(booking.getDriverId());
        Optional<Route> route = routeClient.getRouteById(booking.getRouteId());

        if (vehicle.isEmpty() || driver.isEmpty() || route.isEmpty()) {
            throw new RuntimeException("One or more resources for booking are not available.");
        }

        // Step 2: Set initial booking status and timestamps
        booking.setBookingStatus(Booking.BookingStatus.PENDING);
        booking.setBookingTime(new Timestamp(System.currentTimeMillis()));
        booking.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        booking.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        // Step 3: Save the booking
        return bookingRepository.save(booking);
    }
}
