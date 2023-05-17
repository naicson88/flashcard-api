package com.flashcard.flashcard.enums;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum ETaskColor {
	
	COLOR1("color-1"),
	COLOR2("color-2"),
	COLOR3("color-3"),
	COLOR4("color-4"),
	COLOR5("color-5");
	
	private final String name;
	
	ETaskColor(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static final ETaskColor getByName(String colorName) {
		return Arrays.stream(ETaskColor.values())
				.filter(color -> color.name.equals(colorName)).findFirst()
				.orElseThrow(() ->  new NoSuchElementException("Invalid Task Color! " + colorName));
	}
	
}
