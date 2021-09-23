package com.fazial.filedemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fazial.filedemo.model.Doc;
import com.fazial.filedemo.model.User;
import com.fazial.filedemo.service.DocStorageService;

@RestController
@RequestMapping("/api")
public class DocController {
	
	@Autowired 
	private DocStorageService docStorageService;
	
	@GetMapping("/getFiles")
	public List<Doc> get() {
		List<Doc> docs = docStorageService.getFiles();
		return docs;
	}
	
	@GetMapping("/getFilesForUser/{userID}")
	public List<Doc> getFilesForUser(@PathVariable("userID") int userID) {
		List<Doc> docs = docStorageService.getFilesForUser(userID);
		return docs;
	}
	
	@GetMapping("/getFile/{file_id}")
	public Doc getFile(@RequestParam("fileID") int file_id) {
		Doc doc = docStorageService.getFile(file_id);
		return doc;
	}
	
	@GetMapping("/getPostsForFile/{fileID}")
	public String getPostsForFile(@PathVariable("fileID") int file_id) {
		return docStorageService.getPostsForFile(file_id);
	}
	
	@GetMapping("/getCommentsForPost/{postID}")
	public String getCommentsForPost(@PathVariable("postID") int postID) {
		return docStorageService.getCommentsForPost(postID);
	}
	
	@PostMapping("/addPost")
	public String addPost(@RequestParam("fileID") int fileID, @RequestParam("body") String body, @RequestParam("title") String title) {
		return docStorageService.createPostsForFile(fileID, title, body);
	}
	
	@PostMapping("/addComment")
	public String addComment(@RequestParam("postID") int postID, @RequestParam("body") String body) {
		return docStorageService.createCommentForPost(postID, body);
	}
	
	@PostMapping("/uploadFile")
	public Doc uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userID") int userID) {
		return docStorageService.saveFile(file,userID);
	}
	
	@PostMapping("/updateFile")
	public Doc updateFile(@RequestParam("file") MultipartFile file, @RequestParam("fileID") int fileID) {
		return docStorageService.updateFile(file, fileID);
	}
	
	@DeleteMapping("/deleteFile/{fileID}")
	public Doc deleteFile(@PathVariable("fileID") int file_id) {
		return docStorageService.removeFile(file_id);
	}
	
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId){
		Doc doc = docStorageService.getFile(fileId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}

}
