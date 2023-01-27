package com.flashcard.flashcard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.repository.FolderRepository;

//@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) // Usado com Junit5 ao inves do RunWith
public class FolderServiceTest {
	
	@Spy
	@InjectMocks
	FolderService folderService;
	
	@Mock
	FolderRepository repository;
	
	@BeforeEach
	public void setup(){
	    MockitoAnnotations.openMocks(this); //without this you will get NPE
	}
	
	@Test
	public void successCreateFolder() {		
		Folder f = new Folder();
		f.setName("TestName");
		
		Mockito.when(repository.save(f)).thenReturn(FolderMock.createFolder());
		
		Folder savedFolder = folderService.createFolder(f);
		
		assertNotNull(savedFolder);
		assertEquals("name", savedFolder.getName());	
	}
	
	@Test
	public void invalidFolderName() {
		Folder f = FolderMock.createFolder();
		f.setName(null);
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 folderService.createFolder(f); 
		});
		
		String expected = "Folder name is invalid";
		String actual = exception.getMessage();
		
		assertTrue(actual.contains(expected));
	}
}
