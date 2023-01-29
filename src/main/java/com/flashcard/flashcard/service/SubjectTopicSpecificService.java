package com.flashcard.flashcard.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flashcard.flashcard.model.SubjectTopic;
import com.flashcard.flashcard.model.SubjectTopicSpecific;
import com.flashcard.flashcard.repository.SubjectTopicSpecificRepository;

@Service
public class SubjectTopicSpecificService {
	
	SubjectTopicSpecificRepository repository;
	
	SubjectTopicService subjectTopicService;
	
	public SubjectTopicSpecificService(SubjectTopicSpecificRepository repository, SubjectTopicService subjectTopicService) {
		this.repository = repository;
		this.subjectTopicService = subjectTopicService;
	}
	
	public SubjectTopicSpecific create(SubjectTopicSpecific specific) {
		
		SubjectTopic topic = subjectTopicService.findById(specific.getSubjectTopic().getId());
		
		specific.setCreationDate(new Date());
		
		specific = repository.save(specific);
		
		if(topic.getSubjectTopicSpecific() == null)
			topic.setSubjectTopicSpecific(List.of(specific));
		else
			topic.getSubjectTopicSpecific().add(specific);
		
		subjectTopicService.editSubject(topic);
		
		return repository.save(specific);
	}
}
