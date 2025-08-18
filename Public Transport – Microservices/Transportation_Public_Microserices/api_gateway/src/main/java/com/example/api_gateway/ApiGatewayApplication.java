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
                .route("vehicle-service", r -> r.path("/api/vehicles/**")
                        .uri("http://localhost:1112"))
                .route("route-service", r -> r.path("/api/routes/**")
                        .uri("http://localhost:1113"))
                .route("driver-service", r -> r.path("/api/drivers/**")
                        .uri("http://localhost:1114"))
                .route("booking-service", r -> r.path("/api/bookings/**")
                        .uri("http://localhost:1115"))
                .build();
    }
}
