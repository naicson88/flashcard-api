package com.flashcard.flashcard.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flashcard.flashcard.enums.QuestionAnswer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "folder")
public class Quiz {
	
	@Id
	private String id;
	@DocumentReference(lazy = true)
	@JsonIgnore
	private User user;
	@DBRef()
	@JsonBackReference
	private List<Card> nonAnsweredQuestions;
	@DBRef()
	@JsonBackReference
	private List<Card> answeredQuestions;
	private LocalDateTime startTime;
	private LocalDateTime finishTime;
	private Map<String, QuestionAnswer> questionResponse;
	
	
}
