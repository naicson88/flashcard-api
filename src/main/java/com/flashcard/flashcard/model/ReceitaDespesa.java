package com.flashcard.flashcard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "atividade")
public class ReceitaDespesa {
    @Id
    private String id;
    private String periodo;
    private List<Atividade> receitas;
    private List<Atividade> despesas;
    private Date creationDate;
}
