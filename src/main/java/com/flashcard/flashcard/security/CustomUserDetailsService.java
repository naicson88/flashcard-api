package com.flashcard.flashcard.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flashcard.flashcard.model.User;
import com.flashcard.flashcard.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User existUser = repository.findByUserName(username)
				.orElseThrow(() -> new RuntimeException("Can't find user with name: " + username));
		
		return UserPrincipal.create(existUser);
	}

}
