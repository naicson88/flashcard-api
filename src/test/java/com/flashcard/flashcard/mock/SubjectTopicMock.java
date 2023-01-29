package com.flashcard.flashcard.mock;

import com.flashcard.flashcard.model.Subject;
import com.flashcard.flashcard.model.SubjectTopic;

public class SubjectTopicMock {
	
	
	public static SubjectTopic create() {
		SubjectTopic topic = new SubjectTopic();
		Subject sub = SubjectMock.create();
		topic.setId("id-topic");
		topic.setName("Name");
		topic.setSubject(sub);
		return topic;
	}
}
