package com.fazial.filedemo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Comment {

	
	private String body;
	private int postId;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(String body, int postId) {
		super();
		this.body = body;
		this.postId = postId;
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	
	
}
