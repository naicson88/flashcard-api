package com.flashcard.flashcard.controller;

import com.flashcard.flashcard.model.Compras;
import com.flashcard.flashcard.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({ "v1/compras" })
@CrossOrigin(origins = "*", maxAge = 3600)
public class ComprasController {

    @Autowired
    private ComprasService service;

    @PostMapping()
    private ResponseEntity<Compras> createCompra(@RequestBody Compras compra){
      Compras novoItem = service.createCompra(compra);
        return new ResponseEntity<>(novoItem, HttpStatus.CREATED);
    }

    @GetMapping()
    private ResponseEntity<List<Compras>> getCompras(){
        List<Compras> compras = service.getCompras();
        return new ResponseEntity<>(compras, HttpStatus.OK);
    }

}
