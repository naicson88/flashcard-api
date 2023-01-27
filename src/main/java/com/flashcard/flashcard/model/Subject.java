package com.flashcard.flashcard.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	private String name;
	private Date creationDate;
	private List<SubjectTopic> subjectTopics;
	
}
