package com.flashcard.flashcard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flashcard.flashcard.model.Card;


@Repository
public interface CardRepository extends MongoRepository<Card, String> {
	
}
