package com.flashcard.flashcard.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.flashcard.flashcard.enums.QuestionAnswer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "card")
public class Card {
	
	@Id
	private String id;
	@NotBlank
	private String question;
	@NotBlank
	private String answer;
	private QuestionAnswer questionAnswer;
	@DBRef()
	@JsonBackReference
	private Subject subject;
	private int quantityWrong;
	private int quantityRight;
	private int quantityMiddle;
	private int totalTimesAnswered;
	private double percentageAssertiveness;
	private Date creationDate;
	
}
