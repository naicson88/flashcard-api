package com.flashcard.flashcard.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flashcard.flashcard.model.User;
import com.flashcard.flashcard.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository repository;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public User createUser(User user) {
		
		this.validUserData(user);
		
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		
		return repository.save(user);
	}
	
	private void validUserData(User user) {		
		if(repository.findByUserName(user.getUserName()).isPresent())
			throw new IllegalArgumentException("User with this Username already exists!");
		
		if(repository.findByEmail(user.getEmail()).isPresent())
			throw new IllegalArgumentException("User with this Email already exists!");				
	}
}
