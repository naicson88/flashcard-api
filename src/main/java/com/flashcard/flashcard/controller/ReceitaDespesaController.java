package com.flashcard.flashcard.controller;

import com.flashcard.flashcard.model.ReceitaDespesa;
import com.flashcard.flashcard.service.ReceitaDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({ "v1/receita-despesa" })
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class ReceitaDespesaController {

    @Autowired
    ReceitaDespesaService service;

    @PostMapping()
    public ResponseEntity<ReceitaDespesa> createReceitaDespesa(@Valid @RequestBody ReceitaDespesa receitaDespesa){
        ReceitaDespesa created = service.createReceitaDespesa(receitaDespesa);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ReceitaDespesa>> getAllReceitaDespesa(){
        return new ResponseEntity<>(service.getAllReceitaDespesa(), HttpStatus.OK);
    }

    @PostMapping("/create-default")
    public ResponseEntity<ReceitaDespesa> createDefaultOrcamento(@RequestBody String nome){
        return new ResponseEntity<>(service.createDefault(nome), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrcamento(@PathVariable String id){
        return new ResponseEntity<>(service.deleteOrcamento(id), HttpStatus.OK);
    }
}
