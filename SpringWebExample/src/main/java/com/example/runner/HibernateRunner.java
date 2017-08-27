package com.example.runner;

import com.example.dao.UserDao;
import com.example.model.User;

public class HibernateRunner {

	public static void main(String[] args) {
		
		UserDao dao = new UserDao();
		
		/*User user1 = new User("sagar", "Sagar123", "Sagar", "Nikhade", "sagar@gmail.com", "9890548594");
		
		dao.createUser(user1);*/
		
		dao.getAllUsers();
	}
}
