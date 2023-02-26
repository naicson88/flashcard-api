package com.flashcard.flashcard.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.flashcard.flashcard.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "user")
public class User {
	
	@Id
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	private String userName;
	@NotBlank
	private String password;
	@NotBlank
	@Email
	private String email;
	@NotEmpty
	private List<Roles> roles;
	
	public User(String id) {
		this.id = id;
	}
}
