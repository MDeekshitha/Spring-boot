package com.transportation.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Long vehicleId;
    private Long driverId;
    private Long routeId;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    private Timestamp bookingTime;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public enum BookingStatus { PENDING, CONFIRMED, CANCELLED, COMPLETED }

	public void setBookingStatus(BookingStatus pending) {
		// TODO Auto-generated method stub
		
	}
}
