package com.flashcard.flashcard.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "subject_topic_specific")
public class SubjectTopicSpecific {
	
	private String id;
	private String name;
	private Date creationDate;
}
