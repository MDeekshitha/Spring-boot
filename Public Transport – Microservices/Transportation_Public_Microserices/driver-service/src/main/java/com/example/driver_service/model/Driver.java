package com.example.driver_service.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long driverId;
	private String name;
	private String licenseNumber;
	private String phoneNumber;
	private String email;
	private AvailabilityStatus availabilityStatus;
	private Long vehicleId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public AvailabilityStatus getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", name=" + name + ", licenseNumber=" + licenseNumber + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", availabilityStatus=" + availabilityStatus + ", vehicleId="
				+ vehicleId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
