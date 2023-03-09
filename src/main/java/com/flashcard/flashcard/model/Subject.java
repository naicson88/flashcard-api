package com.flashcard.flashcard.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "subject")
public class Subject {
	
	@Id
	private String id;
	@NotBlank
	private String name;
	private String description;
	private Date creationDate;
	@DBRef()
	@JsonManagedReference
	private List<Card> listCards;
	//@DBRef(db="folder")
	@JsonBackReference
	@DocumentReference()
	@NotNull
	private Folder folder;	
}
