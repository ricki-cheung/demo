/**
 * 
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.User;

/**
 * @author Ricki
 *
 */
@Controller
public class LoginController {	
	
	/**
	 * @return
	 * 登录页面
	 */
	@RequestMapping(path="/login",method=RequestMethod.GET)
	public String loginPage(User user) {
		return "login";
	}
}
