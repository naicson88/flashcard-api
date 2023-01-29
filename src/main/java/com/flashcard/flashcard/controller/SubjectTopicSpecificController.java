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

import com.flashcard.flashcard.model.SubjectTopicSpecific;
import com.flashcard.flashcard.service.SubjectTopicSpecificService;

@RestController
@RequestMapping({ "v1/specifc" })
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class SubjectTopicSpecificController {
	
	@Autowired
	SubjectTopicSpecificService service;
	
	//@PreAuthorize("hasRole('USER')")
	@PostMapping("/create")
	public ResponseEntity<SubjectTopicSpecific> create(@Valid @RequestBody SubjectTopicSpecific specific){
		return new ResponseEntity<>(service.create(specific), HttpStatus.CREATED);
	}
}
