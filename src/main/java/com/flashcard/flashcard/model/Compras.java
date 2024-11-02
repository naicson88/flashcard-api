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
@Document(value = "compras")
public class Compras {
    @Id
    private String id;
    private String name;
    private Date creationDate;
    private String color;
    private List<String> products;

}
