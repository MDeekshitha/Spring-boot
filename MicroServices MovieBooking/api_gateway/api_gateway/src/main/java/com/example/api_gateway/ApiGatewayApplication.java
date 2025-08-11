package com.example.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("movie-service", r -> r.path("/api/movies/**")
                        .uri("http://localhost:1111"))
                .route("customer-service", r -> r.path("/api/customers/**")
                        .uri("http://localhost:2222"))
                .route("theater-service", r -> r.path("/api/theaters/**")
                        .uri("http://localhost:3333"))
                .route("booking-service", r -> r.path("/api/bookings/**")
                        .uri("http://localhost:4444"))
                .build();
    }
}