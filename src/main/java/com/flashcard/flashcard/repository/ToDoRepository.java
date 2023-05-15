package com.flashcard.flashcard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flashcard.flashcard.model.ToDo;

@Repository
public interface ToDoRepository extends MongoRepository<ToDo, String>{

	ToDo findByUserId(String userId);

	ToDo findByUser(String userId);

}
