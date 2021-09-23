package com.fazial.filedemo.utils;

import com.fazial.filedemo.beans.Comment;
import com.fazial.filedemo.beans.Post;
import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostUtils {
	
	private String destinationURL = "https://my-json-server.typicode.com/faizal-carim/posts/";
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	public PostUtils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String runGenericRquest(String uri) {
		 String jsonResult = "";
		  
		  try{
			  OkHttpClient client = new OkHttpClient();
			  Request request = new Request.Builder()
					  .url(uri)
					  .get()
					  .build();
			  Response response = client.newCall(request).execute();
			  String res = response.body().string();
			  response.body().close();
			  return res;
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  
		  return jsonResult;
	}
	
	public String runGenericPostRquest(String uri, String body) {
		 String jsonResult = "";
		  
		  try{
			  OkHttpClient client = new OkHttpClient();
			  RequestBody formBody = RequestBody.create(JSON, body);
				Request request = new Request.Builder()
				  .url(uri)
				  .post(formBody)
				  .addHeader("accept", "application/json")
				  .build();
				Response response = client.newCall(request).execute();
				String res = response.body().string();
				response.body().close();
				return res;
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  
		  return jsonResult;
	}
	
	public String getPostsForFile(int fileId) {
		return runGenericRquest(this.destinationURL+"posts?doc="+fileId);
	}
	
	public String getCommentsForPost(int postID) {
		return runGenericRquest(this.destinationURL+"comments?postId="+postID);
	}
	
	public String createPostsForFile(int fileId, String title, String body) {
		Post post = new Post(title, body, fileId);
		Gson gson = new Gson();
		return runGenericPostRquest(this.destinationURL+"posts",gson.toJson(post));
	}
	
	public String createCommentForPost(int postId, String body) {
		Comment comment = new Comment(body, postId);
		Gson gson = new Gson();
		return runGenericPostRquest(this.destinationURL+"posts",gson.toJson(comment));
	}
}
