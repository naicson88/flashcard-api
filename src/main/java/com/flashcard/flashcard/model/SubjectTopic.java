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
@Document(value = "subject_topic")
public class SubjectTopic {
	
	@Id
	private String id;
	private String name;
	private Date creationDate;
	List<SubjectTopicSpecific> subjectTopicSpecific;
}	
