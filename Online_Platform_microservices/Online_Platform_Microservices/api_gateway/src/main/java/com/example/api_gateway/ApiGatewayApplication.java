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
                .route("assessment-service", r -> r.path("/api/assessments/**")
                        .uri("http://localhost:1116"))
                .route("classroom-service", r -> r.path("/api/classrooms/**")
                        .uri("http://localhost:1117"))
                .route("course-service", r -> r.path("/api/courses/**")
                        .uri("http://localhost:1118"))
                .route("notification-service", r -> r.path("/api/notifications/**")
                        .uri("http://localhost:1119"))
                .route("user-service", r -> r.path("/api/users/**")
                        .uri("http://localhost:2000"))
                .build();
    }
}
