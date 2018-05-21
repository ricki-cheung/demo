/**
 * 
 */
package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping(path="/login")
	public String login() {
		Subject userSubject = SecurityUtils.getSubject();
		if(userSubject.isAuthenticated()) {
			return "redirect:index";
		}
		
		return "login";
	}
}
