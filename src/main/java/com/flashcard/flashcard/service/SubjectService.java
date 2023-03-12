package com.flashcard.flashcard.service;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flashcard.flashcard.model.Subject;
import com.flashcard.flashcard.repository.SubjectRepository;

@Service
public class SubjectService {
	
	
	SubjectRepository repository;
	FolderService folderService;
	MongoTemplate template;
	CardService cardService;
	//@Lazy is for circular reference
	public SubjectService(SubjectRepository repository, FolderService folderService, MongoTemplate template, CardService cardService) {
		this.repository = repository;
		this.folderService = folderService;
		this.template = template;
		this.cardService = cardService;
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

	@Transactional(rollbackFor = Exception.class)
	public void delelteSubject(String subjectId) {
		Subject sub = this.findById(subjectId);
		sub.getListCards().stream()
			.forEach(q -> {
				if(q != null)
					cardService.deleteCard(q.getId());
			});
		repository.delete(sub);
	}
	
	
}
