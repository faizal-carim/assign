package com.fazial.filedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fazial.filedemo.model.Doc;
import com.fazial.filedemo.model.User;
import com.fazial.filedemo.service.DocStorageService;
import com.fazial.filedemo.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public User uploadFile(@RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail) {
		return userService.saveUser(userName, userEmail);
	}
	
}
