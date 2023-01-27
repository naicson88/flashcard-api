package com.flashcard.flashcard.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.repository.FolderRepository;

@Service
public class FolderService {

	private FolderRepository repository;

	public FolderService(FolderRepository repository) {
		this.repository = repository;
	}

	public Folder createFolder(Folder folder) {		
		this.validateFolder(folder);
		
		folder.setCreationDate(new Date());
		
		return repository.save(folder);
	}

	public Folder editFolder(Folder folder) {
		this.validateFolder(folder);	
		return repository.save(folder);
	}
	
	public List<Folder> findAllByUserId(String userId){
		return repository.findAllByUserId(userId);
	}
	
	private void validateFolder(Folder folder) {
		if (folder.getName() == null || folder.getName().isBlank())
			throw new IllegalArgumentException("Folder name is invalid");
	}
}
