package com.flashcard.flashcard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flashcard.flashcard.model.User;
import com.flashcard.flashcard.service.UserService;

@RestController
@RequestMapping({ "v1/user" })
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create-user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User savedUser = userService.createUser(user);
		
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
}
