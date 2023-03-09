package com.flashcard.flashcard.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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
	SubjectService subjectService;
	
	@Transactional
	public Card createCard(Card card) {
		Subject sub = subjectService.findById(card.getSubject().getId());
			
			card.setCreationDate(new Date());
			card = cardRepository.save(card);
			sub.getListCards().add(card);
			subjectService.editSubject(sub);
			
			return card;

	}
}
