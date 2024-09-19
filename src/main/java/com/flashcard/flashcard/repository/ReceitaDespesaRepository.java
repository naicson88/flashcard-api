package com.flashcard.flashcard.repository;

import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.model.ReceitaDespesa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaDespesaRepository extends MongoRepository<ReceitaDespesa, String> {
}
