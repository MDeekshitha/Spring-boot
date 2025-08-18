package com.example.notification_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notification_service.model.Notification;
import com.example.notification_service.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	NotificationRepository notificationRepository;
	
	public String sendNotification(String message) {
		System.out.println("Notification received: " + message);
		
		 Notification notification = new Notification();
	        notification.setMessage(message);
	        notificationRepository.save(notification);

	        return "Notification sent successfully!";
	}
	public Notification saveNotification(Notification notification) {
		// TODO Auto-generated method stub
		Notification n =notificationRepository.save(notification);
		return n;
	}
	public List<Notification> getAllNotifications() {
		// TODO Auto-generated method stub
		return notificationRepository.findAll();
	}

	public Notification getNotificationById(Long id)  {
		// TODO Auto-generated method stub
		Optional<Notification> assess = notificationRepository.findById(id);
		if(assess.isPresent())
			return notificationRepository.findById(id).get();
		else
			return null;
		//	throw new CustomerNotFoundException("Customer not found with '"+id+"'");
	}

	public void deleteNotification(Long id) {
		// TODO Auto-generated method stub
		notificationRepository.deleteById(id);
	}

}
