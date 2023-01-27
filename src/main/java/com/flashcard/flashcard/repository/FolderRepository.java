package com.flashcard.flashcard.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flashcard.flashcard.model.Folder;

@Repository
public interface FolderRepository extends MongoRepository<Folder, String>{

	@Query(value="{user: ?0 }", count = true)	
	List<Folder> findAllByUserId(String userId);

}
