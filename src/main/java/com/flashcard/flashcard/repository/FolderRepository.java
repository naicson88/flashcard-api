package com.flashcard.flashcard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flashcard.flashcard.model.Folder;

@Repository
public interface FolderRepository extends MongoRepository<Folder, String>{

}
