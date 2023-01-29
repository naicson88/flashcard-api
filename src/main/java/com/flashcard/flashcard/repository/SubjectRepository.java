package com.flashcard.flashcard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flashcard.flashcard.model.Subject;

public interface SubjectRepository extends MongoRepository<Subject, String>{

}
