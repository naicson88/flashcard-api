package com.flashcard.flashcard.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.flashcard.enums.EWeek;
import com.flashcard.flashcard.model.DailyTask;
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
		
		insertAllDailyTasks(todo);
		
		todo.setUser(new User(userId));
		
		return repository.save(todo);
	}
	
	private boolean checkIfUserAlreadyHasToDoCreated(String userId) {
		return repository.findByUser(userId) != null;
	}
	
	private ToDo insertAllDailyTasks(ToDo todo) {
		
		if(todo.getDailyTasks() == null)
			todo.setDailyTasks(new ArrayList<>());
		
		List<EWeek> days = todo.getDailyTasks().stream().map(DailyTask::getDay).collect(Collectors.toList());
		
		for(EWeek day : EWeek.values()) {
			if(!days.contains(day)) {
				todo.getDailyTasks().add(new DailyTask(UUID.randomUUID().toString(), day, Collections.emptyList()));
			}			
		}
		
		todo.setDailyTasks(todo.getDailyTasks().stream().sorted((d1, d2) -> d1.getDay().compareTo(d2.getDay())).toList());
		
		return todo;
	}
	
	public ToDo getToDo() {
		return repository.findByUserId(GeneralFunctions.getUser().getId());
	}
}	
