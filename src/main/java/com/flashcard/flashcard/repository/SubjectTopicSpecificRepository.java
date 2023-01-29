package com.flashcard.flashcard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flashcard.flashcard.model.SubjectTopicSpecific;

public interface SubjectTopicSpecificRepository extends MongoRepository<SubjectTopicSpecific, String>{

}
