package com.flashcard.flashcard.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import com.flashcard.flashcard.enums.EWeek;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DailyTask {	
	@Id
	private String id = UUID.randomUUID().toString();
	private EWeek day;
	private List<Task> tasks;
}
