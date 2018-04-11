package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
		    System.out.println("SecurityManager:"+SecurityUtils.getSecurityManager());
		    Subject userSubject = SecurityUtils.getSubject();
		    System.out.println("userSubject:"+userSubject);
	        return "index";
		
	}
	
	
	
	
	
	
	
	
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
	
	

}
