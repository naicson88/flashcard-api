package com.flashcard.flashcard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flashcard.flashcard.mock.SubjectMock;
import com.flashcard.flashcard.mock.SubjectTopicMock;
import com.flashcard.flashcard.mock.SubjectTopicSpecificMock;
import com.flashcard.flashcard.model.Subject;
import com.flashcard.flashcard.model.SubjectTopic;
import com.flashcard.flashcard.model.SubjectTopicSpecific;
import com.flashcard.flashcard.repository.SubjectTopicSpecificRepository;

//@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) // Usado com Junit5 ao inves do RunWith
public class SubjectTopicSpecificTest {
	
	@Spy
	@InjectMocks
	SubjectTopicSpecificService service;
	
	@Mock
	SubjectTopicSpecificRepository repository;
	
	@Mock
	SubjectTopicService subjectTopicService;
	
	
	@BeforeEach
	public void setup(){
	    MockitoAnnotations.openMocks(this); //without this you will get NPE
	}
	
	@Test
	public void createSpecificTopic() {
		SubjectTopicSpecific spec = SubjectTopicSpecificMock.create();
		SubjectTopic sub = SubjectTopicMock.create();
		
		Mockito.when(subjectTopicService.findById(anyString())).thenReturn(sub);
		Mockito.when(subjectTopicService.editSubject(any())).thenReturn(null);
		Mockito.when(repository.save(spec)).thenReturn(spec);
		
		SubjectTopicSpecific saved = service.create(spec);
		
		assertNotNull(saved);
		assertEquals("id-string", saved.getId());
	}
	
}
