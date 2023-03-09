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

import com.flashcard.flashcard.model.Card;
import com.flashcard.flashcard.service.CardService;

@RestController
@RequestMapping({ "v1/card" })
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class CardController {
	
	@Autowired
	CardService cardService;
	
	@PostMapping("/create-card")
	public ResponseEntity<Card> createCard(@Valid @RequestBody Card card){
		return new ResponseEntity<>(cardService.createCard(card), HttpStatus.OK);
	}
}
