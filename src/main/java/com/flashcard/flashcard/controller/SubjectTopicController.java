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

import com.flashcard.flashcard.model.SubjectTopic;
import com.flashcard.flashcard.service.SubjectTopicService;

@RestController
@RequestMapping({ "v1/subject-topic" })
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class SubjectTopicController {
	
	@Autowired
	SubjectTopicService service;
	
	@PostMapping("/create")
	public ResponseEntity<SubjectTopic> create(@Valid @RequestBody SubjectTopic topic){
		return new ResponseEntity<>(service.create(topic), HttpStatus.CREATED);
	}
}
