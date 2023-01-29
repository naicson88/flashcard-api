package com.flashcard.flashcard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

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
import com.flashcard.flashcard.model.Subject;
import com.flashcard.flashcard.model.SubjectTopic;
import com.flashcard.flashcard.repository.SubjectTopicRepository;

//@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) // Usado com Junit5 ao inves do RunWith
public class SubjectTopicServiceTest {
	
	@Spy
	@InjectMocks
	SubjectTopicService service;
	
	@Mock
	SubjectTopicRepository repository;
	
	@Mock
	SubjectService subjectService;
	
	@BeforeEach
	public void setup(){
	    MockitoAnnotations.openMocks(this); //without this you will get NPE
	}
	
	
	@Test
	public void createSubjectTopic() {
		SubjectTopic topic = SubjectTopicMock.create();
		Subject sub = SubjectMock.create();
		
		Mockito.when(subjectService.findById(anyString())).thenReturn(sub);
		Mockito.when(subjectService.editSubject(any())).thenReturn(null);
		Mockito.when(repository.save(topic)).thenReturn(topic);
		
		
		SubjectTopic saved = service.create(topic);
		
		assertNotNull(saved);
		assertEquals("id-topic", saved.getId());	
	}
	
	
}

