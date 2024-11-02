package com.flashcard.flashcard.repository;

import com.flashcard.flashcard.model.Compras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends MongoRepository<Compras, String> {
}
