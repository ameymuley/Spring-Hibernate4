package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path= "/user/{name}",method=RequestMethod.GET)    
    public String getUserDetails(@PathVariable String name, ModelMap model){
		System.out.println("Inside UserController - name: " + name);
		User user = userService.getUserDetails(name);
		System.out.println("User Details: " + user.toString());
		String userDetails =user.toString();
		System.out.println(userDetails);
		model.addAttribute("user", userDetails);
		return "user";
    }
	
	
	@RequestMapping(path= "/users",method=RequestMethod.GET)    
    public String getAllUsers(ModelMap model){
		System.out.println("Inside getAllUsers");
		List<User> users = userService.getAllUsers();
		model.addAttribute("user", users);
		return "user";
    }
	
	@RequestMapping(path= "/users",method=RequestMethod.POST)
    public String createUser(@RequestBody User user, ModelMap model){
		System.out.println("Inside CreateUserController");
		int userId = userService.createUser(user);
		System.out.println("User Created with ID: " + userId);
		model.addAttribute("user", userId);
		return "user";
    }

}
