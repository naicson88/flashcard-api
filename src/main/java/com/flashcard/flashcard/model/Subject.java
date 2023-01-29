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
	private Date creationDate;
	private List<SubjectTopic> subjectTopics;
	@DBRef
	@DocumentReference()
	@NotNull
	private Folder folder;
	
}
