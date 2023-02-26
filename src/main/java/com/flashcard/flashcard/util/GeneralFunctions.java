package com.flashcard.flashcard.util;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.flashcard.flashcard.security.UserPrincipal;

public class GeneralFunctions {
	
	public static UserPrincipal getUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal user = (UserPrincipal) authentication.getPrincipal();

		if (user == null || user.getId().isBlank())
			throw new InternalAuthenticationServiceException("Could't find user");
		
		return user;
	}
}
