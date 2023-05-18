package com.flashcard.flashcard.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.flashcard.enums.ETaskColor;
import com.flashcard.flashcard.enums.EWeek;
import com.flashcard.flashcard.model.DailyTask;
import com.flashcard.flashcard.model.Task;
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
		
		if(checkIfUserAlreadyHasToDoCreated())
			throw new IllegalArgumentException("User aleady has a ToDo Created!");
		
		insertAllDailyTasks(todo);
		
		todo.setUser(new User(userId));
		
		return repository.save(todo);
	}
	
	private boolean checkIfUserAlreadyHasToDoCreated() {
		try {
			return this.getToDoByUserId() != null;
		} catch (Exception e) {
			return false;
		} 
	}
	
	private void validTaskColor(List<DailyTask> dailyTasks) {	
		dailyTasks.stream()
		.flatMap(day -> day.getTasks().stream())
		.forEach(t -> ETaskColor.getByName(t.getClassColor()));
		
	}

	private ToDo insertAllDailyTasks(ToDo todo) {	
		if(todo.getDailyTasks() == null)
			todo.setDailyTasks(new ArrayList<>());
		
		validTaskColor(todo.getDailyTasks());
		
		List<EWeek> days = todo.getDailyTasks().stream().map(DailyTask::getDay).collect(Collectors.toList());
		
		for(EWeek day : EWeek.values()) {
			if(!days.contains(day)) {
				todo.getDailyTasks().add(new DailyTask(UUID.randomUUID().toString(), day,Collections.emptyList()));
			}			
		}
		
		todo.setDailyTasks(todo.getDailyTasks().stream().sorted((d1, d2) -> d1.getDay().compareTo(d2.getDay())).toList());
		
		return todo;
	}
	
	public ToDo getToDoByUserId() {
		return repository.findByUserId(GeneralFunctions.getUser().getId())
				.orElseThrow(() -> new NoSuchElementException("ToDo not found for userId"));
	}
	
	
	
	public ToDo updateDailyTasks(EWeek day, Task task) {
		if(day == null || task == null)
			throw new IllegalArgumentException("Invalid Day or Task informed!");
		
		ETaskColor.getByName(task.getClassColor());
		
		ToDo todo = this.getToDoByUserId();
		
		int index = EWeek.valueOf(day.toString()).ordinal();
		
		todo.getDailyTasks().get(index).getTasks().add(task);		
		
		return repository.save(todo);
	}
	
	public ToDo removeTask(EWeek day, Integer index) {
		if(day == null || index == null)
			throw new IllegalArgumentException("Invalid Day or Index");
		
		ToDo todo = this.getToDoByUserId();
		int dayIndex = EWeek.valueOf(day.toString()).ordinal();
		
		todo.getDailyTasks().get(dayIndex).getTasks().remove(index.intValue());
		
		return repository.save(todo);	
	}
}	
