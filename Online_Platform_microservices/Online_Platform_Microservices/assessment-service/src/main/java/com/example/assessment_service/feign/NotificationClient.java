package com.example.assessment_service.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "notification-service", url = "http://localhost:5555")
public interface NotificationClient {
	 @PostMapping("/api/notifications/send")
	    String sendNotification(@RequestParam String message);

}
