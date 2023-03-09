package com.flashcard.flashcard.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flashcard.flashcard.model.Subject;
import com.flashcard.flashcard.model.SubjectTopic;
import com.flashcard.flashcard.repository.SubjectTopicRepository;

@Service
public class SubjectTopicService {
	
	SubjectTopicRepository repository;
	
	SubjectService subjectService;
	
	public SubjectTopicService(SubjectTopicRepository repository, SubjectService subjectService) {
		this.repository = repository;
		this.subjectService = subjectService;
	}
	
	@Transactional
	public SubjectTopic create(SubjectTopic topic) {	
		topic.setCreationDate(new Date());
		SubjectTopic topicSaved =  repository.save(topic);
//	
//		subjectService.setSubjectTopic(topicSaved);
		
		return topicSaved;
	}
	
	public SubjectTopic findById(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cant find SubjectTopic with ID: " + id)) ;
	}
	
	public SubjectTopic editSubject(SubjectTopic sub) {
		return repository.save(sub);
	}
	
	
}
