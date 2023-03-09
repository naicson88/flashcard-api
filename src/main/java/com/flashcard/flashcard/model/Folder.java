package com.flashcard.flashcard.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "folder")
public class Folder {
	
	@Id
	private String id;
	@NotBlank
	private String name;
	private String description;
	//@DBRef
	@JsonManagedReference
	@DocumentReference(lazy = false)
	private List<Subject> subjects;
	private Date creationDate;
	//@DBRef
	@DocumentReference(lazy = true)
	@JsonIgnore
	private User user;
}
