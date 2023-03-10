package com.flashcard.flashcard.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.flashcard.flashcard.model.User;

public class UserPrincipal implements UserDetails{

	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserPrincipal(User user) {
		this.id = user.getId();
		this.username = user.getUserName();
		this.password = user.getPassword();
		
		 List<SimpleGrantedAuthority> auths= user.getRoles().stream().map(role -> {
			return new SimpleGrantedAuthority("ROLE_".concat(role.toString()));
		}).collect(Collectors.toList());
		
		this.authorities = auths;
	}
	
	public static UserPrincipal create(User user) {
		return new UserPrincipal(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
