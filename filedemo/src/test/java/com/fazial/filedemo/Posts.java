package com.fazial.filedemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class Posts {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldGetThePosts() throws Exception {
		this.mockMvc.perform(get("/api/getPostsForFile/1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldGetTheComments() throws Exception {
		this.mockMvc.perform(get("/api/getCommentsForPost/1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldAddPost() throws Exception {
		this.mockMvc.perform(post("/api/addPost?fileID=1&body=some sample body&title=this title")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldAddComment() throws Exception {
		this.mockMvc.perform(post("/api/addComment?postID=1&body=some sample body")).andDo(print()).andExpect(status().isOk());
	}

}
