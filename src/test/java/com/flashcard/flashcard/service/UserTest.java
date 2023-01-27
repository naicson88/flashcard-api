package com.flashcard.flashcard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flashcard.flashcard.mock.UserMock;
import com.flashcard.flashcard.model.User;
import com.flashcard.flashcard.repository.UserRepository;

//@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) // Usado com Junit5 ao inves do RunWith
public class UserTest {
	
	@Spy
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository repository;
	
	@BeforeEach
	public void setup(){
	    MockitoAnnotations.openMocks(this); //without this you will get NPE
	}
	
	@Test
	public void createUserSuccessfully() {
		User user = UserMock.createUser();	
		
		Mockito.when(repository.save(user)).thenReturn(user);
		
		User saved = userService.createUser(user);
		
		assertNotNull(saved);
		assertEquals("Name", saved.getName());		
	}
	
	@Test
	public void errorWhenUserAlreadyExistsWithSameName() {
		User user = UserMock.createUser();	
		
		Mockito.when(repository.findByUserName(user.getUserName())).thenReturn(Optional.of(user));
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 userService.createUser(user);
		});
		
		String expected = "User with this Username already exists!";
		String actual = exception.getMessage();
		
		assertTrue(actual.contains(expected));
		
	}
	
	@Test
	public void errorWhenUserAlreadyExistsWithSameEmail() {
		User user = UserMock.createUser();	
		
		Mockito.when(repository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 userService.createUser(user);
		});
		
		String expected = "User with this Email already exists!";
		String actual = exception.getMessage();
		
		assertTrue(actual.contains(expected));
		
	}
}

