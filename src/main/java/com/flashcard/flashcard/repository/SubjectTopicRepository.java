package com.flashcard.flashcard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flashcard.flashcard.model.SubjectTopic;

@Repository
public interface SubjectTopicRepository extends MongoRepository<SubjectTopic, String>{
	
	
}
