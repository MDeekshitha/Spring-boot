package com.example.booking_service_MS.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.booking_service_MS.dto.DriverDTO;
import com.example.booking_service_MS.dto.RouteDTO;
import com.example.booking_service_MS.dto.VehicleDTO;
import com.example.booking_service_MS.model.Booking;
import com.example.booking_service_MS.model.BookingStatus;
import com.example.booking_service_MS.repository.BookingRepository;

@Service
public class BookingService {

    private static final String VEHICLE_SERVICE_URL = "http://vehicle-service/api/vehicles";
    private static final String DRIVER_SERVICE_URL = "http://driver-service/api/drivers";
    private static final String ROUTE_SERVICE_URL = "http://route-service/api/routes";

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory<?, ?> circuitBreakerFactory;

    public Booking createBooking(String customerName, String contactNumber, Long routeId, Long vehicleId, Long driverId) {
        // Retrieve data from other services
        VehicleDTO vehicle = getVehicle(vehicleId);
        DriverDTO driver = getDriver(driverId);
        RouteDTO route = getRoute(routeId);

        if (vehicle == null || driver == null || route == null) {
            throw new RuntimeException("Missing data from dependent services");
        }

        Booking booking = new Booking();
        booking.setCustomerName(customerName);
        booking.setContactNumber(contactNumber);
        booking.setRouteId(routeId);
        booking.setVehicleId(vehicleId);
        booking.setDriverId(driverId);
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        booking.setBookingTime(new Timestamp(System.currentTimeMillis()));
        booking.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        booking.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        Booking saved = bookingRepository.save(booking);
        return saved;
    }
    
    public String placeBooking(Long driverId) {
        DriverDTO driver = findDriver(driverId);
        if (driver != null) {
            Booking book = new Booking();
            book.setBookingId(driver.getDriverId());
            book.setCustomerName(driver.getName());
            book.setBookingTime(new Timestamp(System.currentTimeMillis()));
            bookingRepository.save(driver);
            
//            template.send("orders-batch3", order.getId(),order);

            return "Booking placed for driver: " + driver.getName();
        }
        return "Failed to place order. Driver not found.";
    }

    public DriverDTO findDriver(Long driverId) {
    	org.springframework.cloud.client.circuitbreaker.CircuitBreaker circuitBreaker = circuitBreakerFactory.create("driverService");

        return circuitBreaker.run(
                () -> restTemplate.getForObject(DRIVER_SERVICE_URL + "/"+driverId, DriverDTO.class),
                throwable -> driverFallBack1(driverId, throwable)
        );
	}
    
    public DriverDTO driverFallBack1(Long driverId,Throwable t) {
        System.out.println("Driver service is unavailable, returning fallback data. Cause: " + t.getMessage());
        return new DriverDTO();
    }

	public VehicleDTO getVehicle(Long vehicleId) {
    	org.springframework.cloud.client.circuitbreaker.CircuitBreaker circuitBreaker = circuitBreakerFactory.create("vehicleService");

        return circuitBreaker.run(
                () -> restTemplate.getForObject(VEHICLE_SERVICE_URL + "/"+vehicleId, VehicleDTO.class),
                throwable -> vehicleFallBack(vehicleId, throwable)
        );
    }

    public DriverDTO getDriver(Long driverId) {
    	org.springframework.cloud.client.circuitbreaker.CircuitBreaker circuitBreaker = circuitBreakerFactory.create("driverService");

        return circuitBreaker.run(
                () -> restTemplate.getForObject(DRIVER_SERVICE_URL + "/"+driverId, DriverDTO.class),
                throwable -> driverFallBack1(driverId, throwable)
        );
    }
    public RouteDTO getRoute(Long routeId) {
    	org.springframework.cloud.client.circuitbreaker.CircuitBreaker circuitBreaker = circuitBreakerFactory.create("routeService");

        return circuitBreaker.run(
                () -> restTemplate.getForObject(ROUTE_SERVICE_URL + "/"+routeId, RouteDTO.class),
                throwable -> routeFallBack(routeId, throwable)
        );
    }
    
    public VehicleDTO vehicleFallBack(Long vehicleId,Throwable t) {
        System.out.println("Vehicle service is unavailable, returning fallback data. Cause: " + t.getMessage());
        return new VehicleDTO();
    }
    
    public DriverDTO driverFallBack(Long driverId,Throwable t) {
        System.out.println("Driver service is unavailable, returning fallback data. Cause: " + t.getMessage());
        return new DriverDTO();
    }
    
    public RouteDTO routeFallBack(Long routeId, Throwable t) {
        System.out.println("Route service is unavailable, returning fallback data. Cause: " + t.getMessage());
        return new RouteDTO();
    }

    public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		Booking b = bookingRepository.save(booking);
		return b;
	}

	public Booking getBookingById(Long id) {
		// TODO Auto-generated method stub
		Optional<Booking> book = bookingRepository.findById(id);
		if(book.isPresent())
			return bookingRepository.findById(id).get();
		return null;
	}

	public void deleteBooking(Long id) {
		// TODO Auto-generated method stub
		bookingRepository.deleteById(id);
	}
}