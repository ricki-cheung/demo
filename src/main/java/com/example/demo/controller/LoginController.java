/**
 * 
 */
package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;

/**
 * @author Ricki
 *
 */
@Controller
public class LoginController {
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String loginPage() {
	    return "login";	
	}
	
	
	/**
	 * @return
	 * 处理用户登录操作
	 */
	@RequestMapping("/toLogin")
	public String login(User user) {
		//创建一个用户
		Subject userSubject = SecurityUtils.getSubject();
		//定义一个token
		UsernamePasswordToken token = new UsernamePasswordToken("ricki","cheung");
		//用户登录
		try {
			userSubject.login(token);
		}catch(Exception e) {//TODO 这里可以细分异常类型，做出不同的处理
			e.printStackTrace();
			return "redirect:/login";
		}
		
		return "redirect:/index";
	}
}
