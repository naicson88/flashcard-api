package com.flashcard.flashcard.mock;

import java.util.Date;

import com.flashcard.flashcard.model.Folder;

public class FolderMock {
	
	public static Folder createFolder() {
		return new Folder("id-test", "name", null, new Date(), null);
	}
}
