package com.flashcard.flashcard.mock;

import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.model.Subject;

public class SubjectMock {
	
	public static Subject create() {
		Subject sb = new Subject();
		sb.setId("id-sub");
		sb.setName("name");
		sb.setFolder(new Folder("id-folder", null, null, null, null, null));
		
		return sb;
	}
}
