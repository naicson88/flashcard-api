package com.flashcard.flashcard.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.model.Subject;
import com.flashcard.flashcard.model.User;
import com.flashcard.flashcard.repository.FolderRepository;
import com.flashcard.flashcard.util.GeneralFunctions;

import javax.validation.constraints.NotNull;

@Service
public class FolderService {

	private FolderRepository repository;

	public FolderService(FolderRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Folder createFolder(Folder folder) {		
		
		folder.setUser(new User(GeneralFunctions.getUser().getId()));
		
		folder.setCreationDate(new Date());
		
		return repository.save(folder);
	}
	
	@Transactional
	public Folder editFolder(Folder folder) {
		Folder old = repository.findById(folder.getId())
				.orElseThrow(() -> new IllegalArgumentException("It was not possible find Folder " + folder.getId()));
		
		old.setDescription(folder.getDescription());
		old.setName(folder.getName());
		
		return repository.save(old);
	}
	
	public List<Folder> findAllByUserId(String userId){
		return repository.findAllByUserId(userId);
	}
	
	public Folder findById(String folderId) {	
		return repository.findById(folderId)
				.orElseThrow(() -> new RuntimeException("Folder not found with ID: " + folderId));
	}

	public List<Folder> listFolders() {
		return repository.findAllByUserId(GeneralFunctions.getUser().getId());
	}

	public Page<Folder> listFoldersPagination(Pageable pageable) {
		return repository.findAllByUserIdOrderByCreationDateDesc(GeneralFunctions.getUser().getId(), pageable);
	}
	
	@Transactional
	public void deleteFolder(String folderId) {
		if(repository.findById(folderId).isEmpty())
			throw new NoSuchElementException("Cannot find Folder with ID: " + folderId);
		
		repository.deleteById(folderId);
		
	}
	
	@Transactional
	public Folder saveSubject(@NotNull Subject savedSubject) {
		Folder folder = this.findById(savedSubject.getFolder().getId());
		
		if(folder.getSubjects() == null)
			folder.setSubjects(List.of(savedSubject));
		else
			folder.getSubjects().add(savedSubject);
		
		return repository.save(folder);
		
	}
	

}
