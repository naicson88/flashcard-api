package com.flashcard.flashcard.mock;

import com.flashcard.flashcard.model.SubjectTopic;
import com.flashcard.flashcard.model.SubjectTopicSpecific;

public class SubjectTopicSpecificMock {
	
	public static SubjectTopicSpecific create() {
		SubjectTopicSpecific sb = new SubjectTopicSpecific();
		SubjectTopic sub = SubjectTopicMock.create();
		sb.setId("id-string");
		sb.setName("name");
		sb.setSubjectTopic(sub);
		
		return sb;
	}
}
