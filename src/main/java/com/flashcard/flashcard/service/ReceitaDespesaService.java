package com.flashcard.flashcard.service;

import com.flashcard.flashcard.model.Atividade;
import com.flashcard.flashcard.model.ReceitaDespesa;
import com.flashcard.flashcard.repository.ReceitaDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
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

    public ReceitaDespesa createDefault(String nome) {
        ReceitaDespesa model = new ReceitaDespesa();
        model.setPeriodo(nome);
        model.setCreationDate(new Date());
      List<Atividade> receitas =  List.of(
               new Atividade(encode("Salário"), null, "Salário", 0 ),
               new Atividade(encode("Investimento"), null, "Investimento", 0 )
       );

        List<Atividade> despesas =  List.of(
                new Atividade(encode("Aluguel"), null, "Aluguel", 1000 ),
                new Atividade(encode("Água"), null, "Água", 0 ),
                new Atividade(encode("Luz"), null, "Luz", 0 ),
                new Atividade(encode("Cartão"), null, "Cartão", 0 ),
                new Atividade(encode("Ifood"), null, "Ifood", 0 )
                );

        model.setReceitas(receitas);
        model.setDespesas(despesas);

       return repository.save(model);
    }

    private String encode (String value){
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public String deleteOrcamento(String id) {
       repository.deleteById(id);
       return "Orcamento deletado com sucesso!";
    }
}
