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

import com.flashcard.flashcard.model.Subject;
import com.flashcard.flashcard.service.SubjectService;

@RestController
@RequestMapping({ "v1/subject" })
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class SubjectController {
	
	@Autowired
	SubjectService service;
	
	@PostMapping("/create-subject")
	public ResponseEntity<Subject> createSubject(@Valid @RequestBody Subject subject) throws Exception{
		return new ResponseEntity<>(service.createSubject(subject), HttpStatus.CREATED);
	}
}
