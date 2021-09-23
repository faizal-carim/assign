package com.fazial.filedemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fazial.filedemo.controller.DocController;
import com.fazial.filedemo.controller.UserController;

@SpringBootTest
class DocTest {

	@Autowired
	private DocController docController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(docController).isNotNull();
	}

}
