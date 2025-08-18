package com.example.course_service.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Component
public class Listner {
	
	

    @KafkaListener(topics = "user-enrolled", groupId = "course-group")
    public void listen(String message) {
        System.out.println("===== USER EVENT RECEIVED =====");
        System.out.println(message);
        System.out.println("==============================");

}}
