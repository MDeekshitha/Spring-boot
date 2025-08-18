package com.example.notification_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.notification_service.model.Notification;
import com.example.notification_service.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

	

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public String sendNotification(@RequestParam String message) {
        return notificationService.sendNotification(message);
	
    }
    @GetMapping
	public List<Notification> getAllNotification() {
		return notificationService.getAllNotifications();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
//		String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//		System.out.println(" current running port :" + env.getProperty("local.server.port")+" | Time : "+currentTime);
		System.out.println(" inside getNotificationById");
		Notification notification = notificationService.getNotificationById(id);
		if (notification == null) {
			// throw new CustomerNotFoundException("Customer not found with '"+id+"'");
		}
		return new ResponseEntity<Notification>(notification, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public Notification updateNotification(@RequestBody Notification notification, @PathVariable Long id) {
		Notification existingNotification = notificationService.getNotificationById(id);
		existingNotification.setMessage(notification.getMessage());
		existingNotification.setTimestamp(notification.getTimestamp());

		Notification result = notificationService.saveNotification(existingNotification);

		return result;
	}
	@DeleteMapping("/{id}")
	public String deleteNotification(@PathVariable Long id) {
		notificationService.deleteNotification(id);
		return "Notification deleted with this " + id;
	}
}