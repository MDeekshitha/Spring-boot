package com.example.course_service.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.course_service.dto.UserDTO;

@FeignClient(name = "user-service", url = "http://localhost:2000/api/users")
public interface UserServiceClient {
	@GetMapping("/{id}")
    UserDTO getUserById(@PathVariable("id") Long id);
}
