package com.flashcard.flashcard.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.model.Subject;
import com.flashcard.flashcard.model.SubjectTopic;
import com.flashcard.flashcard.repository.SubjectRepository;

@Service
public class SubjectService {
	
	SubjectRepository repository;
	
	FolderService folderService;
	
	public SubjectService(SubjectRepository repository, FolderService folderService) {
		this.repository = repository;
		this.folderService = folderService;
	}
	
	@Transactional
	public Subject createSubject(Subject subject) {
			
		subject.setCreationDate(new Date());
		Subject savedSubject = repository.save(subject);
			
		folderService.saveSubject(savedSubject);
		
		return savedSubject;
	}

	public Subject findById(String id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Subject with ID: " + id));
	}
	
	public Subject editSubject(Subject subject) {
		return repository.save(subject);
	}
	
//	public Subject setSubjectTopic(SubjectTopic topicSaved) {
//		
//	Subject sub = this.findById(topicSaved.getSubject().getId());
//	
//		if(sub.getSubjectTopics() == null)
//			sub.setSubjectTopics(List.of(topicSaved));
//		else
//			sub.getSubjectTopics().add(topicSaved);
//		
//		return repository.save(sub);
//		
//	}
	
}
