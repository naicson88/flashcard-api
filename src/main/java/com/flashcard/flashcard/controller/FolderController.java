package com.flashcard.flashcard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.service.FolderService;

@RestController
@RequestMapping({ "v1/folder" })
@CrossOrigin(origins = "*", maxAge = 3600)
public class FolderController {
	
	@Autowired
	private FolderService service;
	
	@PostMapping("/create-folder")
	public ResponseEntity<Folder> createFolder(@Valid @RequestBody Folder folder){
		Folder created = service.createFolder(folder);
		
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping("/find-by-userid")
	public ResponseEntity<List<Folder>> findAllByUserId(String userId){
		return new ResponseEntity<>(service.findAllByUserId(userId), HttpStatus.OK);
	}
}
