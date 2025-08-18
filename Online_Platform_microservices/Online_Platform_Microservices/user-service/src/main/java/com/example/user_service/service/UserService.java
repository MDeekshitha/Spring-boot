package com.example.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

	private final String USER_TOPIC = "user-enrolled";
	
	
	public List<User> getAllUsers(){
		return userRepository.findAll();	
	}
	
	public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
	
	public User registerUser(User user) {
	    User savedUser = userRepository.save(user);
	    
	    kafkaTemplate.send(USER_TOPIC, "User registered: " + savedUser.getEmail()+ "," +savedUser.getName());
	    return savedUser;
	}
	
	 public Optional<User> loginUser(String email, String rawPassword) {
	        Optional<User> userOpt = userRepository.findByEmail(email);
	        if(userOpt.isPresent() && rawPassword.equals(userOpt.get().getPassword())) {
	            return userOpt;
	        }
	        return Optional.empty();
	    }
}
