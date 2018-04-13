/**
 * 
 */
package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String login() {
		Subject userSubject = SecurityUtils.getSubject();
		if(userSubject.isAuthenticated()) {
			return "redirect:index";
		}
		
		return "login";
	}
}
