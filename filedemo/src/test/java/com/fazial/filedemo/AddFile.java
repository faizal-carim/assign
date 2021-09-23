package com.fazial.filedemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class AddFile {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldGetTheForUser() throws Exception {
		this.mockMvc.perform(get("/api/getFilesForUser/1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldAddTheFile() throws Exception {
		
		 FileInputStream fis = new FileInputStream("C:\\Users\\A201158\\Downloads\\MetroBill.pdf");
		 MockMultipartFile multipartFile = new MockMultipartFile("file", fis);

	   // MockMvc mockMvc  = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	  // mockMvc.perform(post("/api/uploadFile").
	    // .andExpect(status().isOk());
		
		 
		 //this.mockMvc.perform(post("/api/uploadFile?file="+multipartFile.getBytes()+"&userID=1")).andDo(print()).andExpect(status().isOk());
//        FileInputStream fis = new FileInputStream("C:\\Users\\A201158\\Downloads\\MetroBill.pdf");
//        MockMultipartFile multipartFile = new MockMultipartFile("file", fis);
//
//        HashMap<String, String> contentTypeParams = new HashMap<String, String>();
//        contentTypeParams.put("boundary", "265001916915724");
//        MediaType mediaType = new MediaType("multipart", "form-data", contentTypeParams);
//
//        this.mockMvc.perform(
//                post("http://localhost:8777/api/uploadFile")
//                .content(multipartFile.getBytes())
//                .contentType(mediaType))
//                .andExpect(status().isOk());
	}

}
