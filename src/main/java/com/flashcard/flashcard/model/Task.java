package com.flashcard.flashcard.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	
	private String id = UUID.randomUUID().toString();
	private String name;
	@NotBlank
	private String classColor;
	private String time;

}
