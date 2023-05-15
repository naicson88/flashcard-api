package com.flashcard.flashcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.flashcard.model.ToDo;
import com.flashcard.flashcard.model.User;
import com.flashcard.flashcard.repository.ToDoRepository;
import com.flashcard.flashcard.util.GeneralFunctions;

@Service
public class ToDoService {
	
	@Autowired
	ToDoRepository repository;
	
	public ToDo createToDo(ToDo todo) {
		String userId = GeneralFunctions.getUser().getId();
		
		if(checkIfUserAlreadyHasToDoCreated(userId))
			throw new IllegalArgumentException("User aleady has a ToDo Created!");
		
		todo.setUser(new User(userId));
		
		return repository.save(todo);
	}
	
	private boolean checkIfUserAlreadyHasToDoCreated(String userId) {		
		return repository.findByUser(userId) == null;
	}
}	
