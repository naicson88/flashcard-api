package com.flashcard.flashcard.service;

import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.model.ReceitaDespesa;
import com.flashcard.flashcard.model.User;
import com.flashcard.flashcard.repository.ReceitaDespesaRepository;
import com.flashcard.flashcard.util.GeneralFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReceitaDespesaService {

    @Autowired
    ReceitaDespesaRepository repository;

    @Transactional
    public ReceitaDespesa createReceitaDespesa(ReceitaDespesa receitaDespesa) {

      receitaDespesa.setCreationDate(new Date());

        return repository.save(receitaDespesa);
    }

    public List<ReceitaDespesa> getAllReceitaDespesa() {
        return repository.findAll();
    }
}
