package com.example.demo.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.example.demo.service.MenuTreeService;
import com.example.demo.util.ApplicationContextUtil;


/**
 * @author yanzhiying
 *
 */
public class MyAuthenticationFilter extends FormAuthenticationFilter{
	
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		
		Session session = subject.getSession();
		MenuTreeService menuService = ApplicationContextUtil.getBean("menuTreeService", MenuTreeService.class);
		if(menuService != null) {
			session.setAttribute("treeMenu", menuService.getMenu(1));
		}
		
		/*
		 * if(request instanceof ShiroHttpServletRequest) {
			HttpSession httpSession = ((ShiroHttpServletRequest)request).getSession();
			//TODO 把菜单添加到httpSession中
			httpSession.setAttribute("treeMenu", "alensic");
		}*/
		
		return super.onLoginSuccess(token, subject, request, response);
	}
	
}
