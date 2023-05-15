package com.flashcard.flashcard.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "todo")
public class ToDo {
	
	@Id
	private String id;
	private List<DailyTask> dailyTasks;
	@DocumentReference(lazy = true)
	@JsonIgnore
	private User user;
}
