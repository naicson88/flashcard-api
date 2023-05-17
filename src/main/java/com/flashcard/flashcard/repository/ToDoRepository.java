package com.flashcard.flashcard.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flashcard.flashcard.model.ToDo;

@Repository
public interface ToDoRepository extends MongoRepository<ToDo, String>{

	Optional<ToDo> findByUserId(String userId);

}
