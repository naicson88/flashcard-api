package com.flashcard.flashcard.mock;

import com.flashcard.flashcard.model.User;

public class UserMock {
	
	public static User createUser() {
		 User user = new User();
		 user.setId("teste-id");
		 user.setName("Name");
		 user.setPassword("password");
		 user.setUserName("User Name");
		 user.setEmail("email");
		 return user;
	}
}
