package com.example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;

@Service
public class UserService {
	
	List<User> users;
	
	@Autowired
	private UserDao userDao;
	
	/*public UserService() {
		users = new ArrayList<User>();
		users.add(new User("ameya", "Ameya123", "Amey", "Muley", "ameya@gmail.com", "9421744726"));
		users.add(new User("sagar", "Sagar123", "Sagar", "Nikhade", "sagar@gmail.com", "9890548594"));
		users.add(new User("gaurav", "Gaurav123", "Gaurav", "Bhatt", "gaurav@gmail.com", "8877665544"));
	}*/

	public List<User> getAllUsers(){
		users = userDao.getAllUsers();
		return users;
	}

	public User getUserDetails(String username) {
		System.out.println("Inside getUserDetails Service: processing...");
		
		User user = userDao.getUser(username);
		return user;
	}
	
	public int createUser(User user) {
		int userId = userDao.createUser(user);
		return userId;
	}

}
