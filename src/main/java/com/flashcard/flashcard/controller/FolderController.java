package com.flashcard.flashcard.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "v1/folder" })
@CrossOrigin(origins = "*", maxAge = 3600)
public class FolderController {
	
}
