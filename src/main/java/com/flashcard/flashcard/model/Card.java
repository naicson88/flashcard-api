package com.flashcard.flashcard.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class Card {
	
	@Id
	private String id;
	private String question;
	private String answer;
	private QuestionAnswer questionAnswer;
	private Subject subject;
	private SubjectTopic subjectTopic;
	private SubjectTopicSpecific subjectTopicSpecific;
	private Date creationDate;
	
}
