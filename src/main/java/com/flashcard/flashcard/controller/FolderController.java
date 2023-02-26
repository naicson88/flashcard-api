package com.flashcard.flashcard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flashcard.flashcard.model.Folder;
import com.flashcard.flashcard.service.FolderService;
import com.flashcard.flashcard.util.GeneralFunctions;

@RestController
@RequestMapping({ "v1/folder" })
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class FolderController {
	
	@Autowired
	private FolderService service;
	
	@PostMapping("/create-folder")
	public ResponseEntity<Folder> createFolder(@Valid @RequestBody Folder folder){
		Folder created = service.createFolder(folder);
		
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	//@PreAuthorize("hasRole('USER')")
	@GetMapping("/find-by-userid")
	public ResponseEntity<List<Folder>> findAllByUserId(String userId){
		return new ResponseEntity<>(service.findAllByUserId(userId), HttpStatus.OK);
	}
	
	@GetMapping("/find-by-id")
	public ResponseEntity<Folder> findById(@RequestParam String folderId) throws Exception{
		return new ResponseEntity<>(service.findById(folderId), HttpStatus.OK);
	}
	
	@GetMapping("list-folder")
	public ResponseEntity<List<Folder>> listFolders() {
		return new ResponseEntity<>(service.listFolders(), HttpStatus.OK);
	}
	
	@GetMapping("paginated-folder-list")
	public ResponseEntity<Page<Folder>> listFoldersPagination(
			@PageableDefault(page = 0, size = 8, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return new ResponseEntity<>(service.listFoldersPagination(pageable), HttpStatus.OK);
	}
	
	@DeleteMapping("/remove-folder")
	public ResponseEntity<String> deleteFolder(@RequestParam String folderId){
		service.deleteFolder(folderId);
		return new ResponseEntity<>("Folder deleted successfully!", HttpStatus.OK);
	}
	
	@PutMapping("/edit-folder")
	public ResponseEntity<String> editFolder(@Valid @RequestBody Folder folder){
		service.editFolder(folder);
		return new ResponseEntity<>("Folder was edited successfully", HttpStatus.OK);
	}
}
