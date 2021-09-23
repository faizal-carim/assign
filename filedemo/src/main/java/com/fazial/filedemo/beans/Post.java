package com.fazial.filedemo.beans;


public class Post {
	 
	private String title;
	private String body;
	private int doc; 
	public Post() {  
		super(); 
		// TODO Auto-generated constructor stub
	}
	public Post(String title, String body, int doc) {
		super();
		this.title = title;
		this.body = body;  
		this.doc = doc;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getDoc() {
		return doc;
	}
	public void setDoc(int doc) {
		this.doc = doc;
	}
	
	
}
