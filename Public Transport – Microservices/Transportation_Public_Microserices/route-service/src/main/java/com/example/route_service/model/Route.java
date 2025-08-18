package com.example.route_service.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long routeId;
	private String source;
	private String destination;
	private Double distanceKm;
	private Integer estimatedDurationMin;
	private List<String> stops;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getDistanceKm() {
		return distanceKm;
	}
	public void setDistanceKm(Double distanceKm) {
		this.distanceKm = distanceKm;
	}
	public Integer getEstimatedDurationMin() {
		return estimatedDurationMin;
	}
	public void setEstimatedDurationMin(Integer estimatedDurationMin) {
		this.estimatedDurationMin = estimatedDurationMin;
	}
	public List<String> getStops() {
		return stops;
	}
	public void setStops(List<String> stops) {
		this.stops = stops;
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
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", distanceKm="
				+ distanceKm + ", estimatedDurationMin=" + estimatedDurationMin + ", stops=" + stops + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
