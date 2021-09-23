package com.fazial.filedemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fazial.filedemo.model.Doc;
import com.fazial.filedemo.model.User;
import com.fazial.filedemo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(int userID) {
		return userRepository.findById(userID).orElse(null);
	}

	public User saveUser(String userName, String userEmail) {
		User user = new User(userName, userEmail);
		return userRepository.save(user);
	}
	
	public User reomveFileForUser(User user, int fileID) {
		List<Doc> doucments = new ArrayList<Doc>();
		for(Doc document : user.getDocuments()) {
			if(document.getId() != fileID) {
				doucments.add(document);
			}
		}
		user.setDocuments(doucments);
		return userRepository.save(user);
	}
}
