package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class indexController {
	
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping("/")
	public String indexs() {
		return "login";
	}
	
	@RequestMapping("/toindex")
	public	String handleLogin(User user,Model model){
	        return "index";
		
	}
	
	
	
	
	
	
	
	
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
	
	

}
