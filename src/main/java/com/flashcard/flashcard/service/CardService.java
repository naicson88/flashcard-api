package com.flashcard.flashcard.service;

import java.util.Date;
import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flashcard.flashcard.model.Card;
import com.flashcard.flashcard.model.Subject;
import com.flashcard.flashcard.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	MongoTemplate template;
	
	@Transactional
	public Card createCard(Card card) {
		Subject sub = template.findById(card.getSubject().getId(), Subject.class);
		
		if(sub == null)
			throw new IllegalArgumentException("Subject with ID: " + card.getSubject().getId() + " not found!");
		
		card.setCreationDate(new Date());
		card = cardRepository.save(card);
		sub.getListCards().add(card);

		template.save(sub);
		
		return card;
	}
	
	@Transactional
	public void deleteCard(String cardId) {
		
		if(cardRepository.findById(cardId).isEmpty())
			throw new NoSuchElementException("Cannot find Card with ID: " + cardId);
		
		cardRepository.deleteById(cardId);
	}
}
