package com.fazial.filedemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fazial.filedemo.model.Doc;
import com.fazial.filedemo.model.User;
import com.fazial.filedemo.repository.DocRepository;
import com.fazial.filedemo.repository.UserRepository;
import com.fazial.filedemo.utils.PostUtils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class DocStorageService {

	@Autowired
	private DocRepository docRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private PostUtils postUtils;
	
	public Doc saveFile(MultipartFile file, int userID) {
		  String docname = file.getOriginalFilename();
		  try {
			  User user = userRepository.findById(userID).orElse(null);
			  Doc doc = new Doc(docname,file.getContentType(),user, file.getBytes());
			  //user.getDocuments().add(doc);
			  //userRepository.save(user);
			  return docRepository.save(doc);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return null;
	  }
	
	public Doc updateFile(MultipartFile file, int fileId) {
		  String docName = file.getOriginalFilename();
		  try {
			  Doc doc = docRepository.findById(fileId).orElse(null);
			  if(doc != null) {
				  doc.setDocName(docName);
				  doc.setData(file.getBytes());
			  }
			  return docRepository.save(doc);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return null;
	  }
	
	
	  public Doc getFile(int fileId) {
		  return docRepository.findById(fileId).orElse(null);
	  }
	  
	  public String getPostsForFile(int fileId) {
		  postUtils = new PostUtils();
		  return postUtils.getPostsForFile(fileId);
	  }
	  
	  public String getCommentsForPost(int postId) {
		  postUtils = new PostUtils();
		  return postUtils.getCommentsForPost(postId);
	  }
	  
	  public String createCommentForPost(int postId, String body) {
		  postUtils = new PostUtils();
		  return postUtils.createCommentForPost(postId, body);
	  }
	  
	  public String createPostsForFile(int fileId, String title, String body) {
		  postUtils = new PostUtils();
		  return postUtils.createPostsForFile(fileId, title, body);
	  }
	  
	  public Doc removeFile(int fileId) {
		  Doc doc = docRepository.findById(fileId).orElse(null);
		  if(doc != null)
			  docRepository.deleteById(fileId);
		  return doc;
	  }
	  
	  public List<Doc> getFilesForUser(int userID){
		  List<Doc> docs = new ArrayList<Doc>();
		  User user = userRepository.findById(userID).orElse(null);
		  for(Doc doc : docRepository.findAll()) {
			  if(doc.getOwner() == user)
				  docs.add(doc);
		  }
		  return docs;
	  }
	  
	  public List<Doc> getFiles(){
		  return docRepository.findAll();
	  }
	
}
