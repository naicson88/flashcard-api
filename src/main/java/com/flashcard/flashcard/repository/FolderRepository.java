package com.flashcard.flashcard.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flashcard.flashcard.model.Folder;

@Repository
public interface FolderRepository extends MongoRepository<Folder, String>{

	@Query(value="{user: ?0 }", count = true)	// no banco { "user" : DBRef("user", ObjectId("63d3352b88b7f266250927aa")) }
	List<Folder> findAllByUserId(String userId);

	Page<Folder> findAllByUserIdOrderByCreationDateDesc(String id, Pageable pageable);

}
