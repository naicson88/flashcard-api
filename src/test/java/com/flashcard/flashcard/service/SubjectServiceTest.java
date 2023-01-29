package com.flashcard.flashcard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flashcard.flashcard.mock.FolderMock;
import com.flashcard.flashcard.mock.SubjectMock;
import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.model.Subject;
import com.flashcard.flashcard.model.SubjectTopicSpecific;
import com.flashcard.flashcard.repository.SubjectRepository;

//@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) // Usado com Junit5 ao inves do RunWith
public class SubjectServiceTest {
	
	@Spy
	@InjectMocks
	SubjectService service;
	
	@Mock
	SubjectRepository repository;
	
	@Mock
	FolderService folderService;
	
	@BeforeEach
	public void setup(){
	    MockitoAnnotations.openMocks(this); //without this you will get NPE
	}
	
	@Test
	public void createNewSubject() throws Exception {
		Subject sb = SubjectMock.create();
		Folder f = FolderMock.createFolder();
		
		Mockito.when(folderService.findById(anyString())).thenReturn(f);
		Mockito.when(folderService.editFolder(any())).thenReturn(null);
		Mockito.when(repository.save(sb)).thenReturn(sb);
		
		Subject saved = service.createSubject(sb);
		
		assertNotNull(saved);
		assertEquals("id-sub", saved.getId());	
	}
	

}
