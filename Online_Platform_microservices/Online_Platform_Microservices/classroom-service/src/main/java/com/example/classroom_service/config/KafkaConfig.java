package com.example.classroom_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class KafkaConfig {
	    
	 @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
	            ConsumerFactory<String, String> consumerFactory) {
	        ConcurrentKafkaListenerContainerFactory<String, String> factory =
	                new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory);
	        return factory;
	    }
	 
	 @KafkaListener(topics = "class-created", groupId = "classroom-group")
	    public void listenClassCreated(String message) {
	        System.out.println("Received class created event: " + message);
	 }


	    

	 
}


