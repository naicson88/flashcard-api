package com.flashcard.flashcard.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
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
@Document(value = "subject_topic_specific")
public class SubjectTopicSpecific {
	
	@Id
	private String id;
	@NotBlank
	private String name;
	private Date creationDate;
	@DBRef
	@DocumentReference()
	@NotNull
	private SubjectTopic subjectTopic;
}
