package com.example.demo.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;


/**
 * @author Administrator
 *
 */
public class MyAuthenticationFilter extends FormAuthenticationFilter{
	
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		
		if(request instanceof ShiroHttpServletRequest) {
			HttpSession httpSession = ((ShiroHttpServletRequest)request).getSession();
			//TODO 把菜单添加到httpSession中
			httpSession.setAttribute("treeMenu", "alensic");
		}
		
		return super.onLoginSuccess(token, subject, request, response);
	}
	
}
