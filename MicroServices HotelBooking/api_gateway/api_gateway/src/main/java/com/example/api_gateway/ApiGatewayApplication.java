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
                .route("hotel-service", r -> r.path("/api/hotels/**")
                        .uri("http://localhost:2001"))
                .route("room-service", r -> r.path("/api/rooms/**")
                        .uri("http://localhost:2002"))
                .route("customer-service", r -> r.path("/api/customers/**")
                        .uri("http://localhost:2003"))
                .route("booking-service", r -> r.path("/api/bookings/**")
                        .uri("http://localhost:2004"))
                .build();
    }
}
