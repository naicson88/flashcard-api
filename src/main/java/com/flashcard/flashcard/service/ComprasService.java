package com.flashcard.flashcard.service;

import com.flashcard.flashcard.model.Compras;
import com.flashcard.flashcard.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository repository;

    public Compras createCompra(Compras compra) {
        System.out.println("Criando nova Compra");
        compra.setCreationDate(new Date());
        return repository.save(compra);
    }

    public List<Compras> getCompras(){
        return repository.findAll();
    }
}
