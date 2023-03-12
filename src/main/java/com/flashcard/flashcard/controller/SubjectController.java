package com.flashcard.flashcard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Subject> createSubject(@Valid @RequestBody Subject subject) {
		return new ResponseEntity<>(service.createSubject(subject), HttpStatus.CREATED);
	}
	
	@GetMapping("/get-subject")
	public ResponseEntity<Subject> findById(@RequestParam String subjectId){
		return new ResponseEntity<>(service.findById(subjectId), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-subject")
	public ResponseEntity<String> deleteSubject(@RequestParam String subjectId){
		service.delelteSubject(subjectId);
		return new ResponseEntity<>("Subject deleted successfully", HttpStatus.OK);
	}
	
}
