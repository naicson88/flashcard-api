package com.flashcard.flashcard.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.model.Subject;
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
	public Subject createSubject(Subject subject) throws Exception {
		
		Folder folder = folderService.findById(subject.getFolder().getId());
		
		subject.setCreationDate(new Date());
		Subject savedSubject = repository.save(subject);
		
		if(folder.getSubjects() == null)
			folder.setSubjects(List.of(subject));
		else
			folder.getSubjects().add(savedSubject);
		
		folderService.editFolder(folder);
		
		return savedSubject;
	}

	public Subject findById(String id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Subject with ID: " + id));
	}
	
	public Subject editSubject(Subject subject) {
		return repository.save(subject);
	}
	
}
