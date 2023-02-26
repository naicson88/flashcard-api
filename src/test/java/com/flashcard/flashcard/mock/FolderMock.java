package com.flashcard.flashcard.mock;

import java.util.Date;

import com.flashcard.flashcard.model.Folder;

public class FolderMock {
	
	public static Folder createFolder() {
		return new Folder("id-folder", "name", null, null, new Date(), null);
		
	}
}
