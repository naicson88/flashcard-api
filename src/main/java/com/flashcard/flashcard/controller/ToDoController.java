package com.flashcard.flashcard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flashcard.flashcard.model.ToDo;
import com.flashcard.flashcard.service.ToDoService;

@RestController
@RequestMapping({ "v1/todo" })
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class ToDoController {
	
	@Autowired
	ToDoService service;
	
	@PostMapping("/create")
	public ResponseEntity<ToDo> createToDo(@Valid @RequestBody ToDo todo){
		ToDo created = service.createToDo(todo);
		
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-todo")
	public ResponseEntity<ToDo> getToDo(){
		return new ResponseEntity<>(service.getToDo(), HttpStatus.OK);
	}
}
