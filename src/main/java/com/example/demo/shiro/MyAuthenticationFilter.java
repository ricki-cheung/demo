package com.example.demo.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.service.MenuTreeService;
import com.example.demo.service.UserService;

import net.sf.json.JSONArray;
public class MyAuthenticationFilter extends FormAuthenticationFilter{
	@Autowired
	private MenuTreeService menuTreeService;
	@Autowired
	private UserService userService;
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		
		Session session = subject.getSession();
		User user = userService.getUserByUserName(subject.getPrincipal().toString());
		JSONArray treeMenu = menuTreeService.getMenu(user.getId());
		session.setAttribute("treeMenu",treeMenu );
		
		return super.onLoginSuccess(token, subject, request, response);
	}
	
}
