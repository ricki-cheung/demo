package com.example.demo.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.util.StringUtils;

import com.example.demo.config.WebConfig;
import com.example.demo.service.MenuTreeService;
import com.example.demo.util.ApplicationContextUtils;

import net.sf.json.JSONObject;


/**
 * @author yanzhiying
 *
 */
public class MyAuthenticationFilter extends FormAuthenticationFilter{
	
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		Session session = subject.getSession();
		
		Device device = DeviceUtils.getCurrentDevice(WebUtils.toHttp(request));
		
		//如果不是传统浏览器访问
		if(!device.isNormal()) {//因为是浏览器查看，所以这里会为true
			JSONObject resultJson = new JSONObject();
			String userToken = UUID.randomUUID().toString();
			session.setAttribute(WebConfig.USER_TOKEN_SESSION_KEY, userToken);	
			resultJson.put(WebConfig.IS_LOGGED, true);
			resultJson.put(WebConfig.USER_TOKEN_SESSION_KEY, userToken);
			resultJson.put(ShiroHttpSession.DEFAULT_SESSION_ID_NAME, 
					session.getId());
			response.getWriter().write(resultJson.toString());
			response.getWriter().flush();
			
	        //把token缓存在
			EhCacheManager cacheManager = ApplicationContextUtils.getBean("cacheManager", EhCacheManager.class);
			if(cacheManager != null) {
				Cache<String,Object> cache = cacheManager.getCache(WebConfig.USER_TOKEN_CACHE_NAME);
				if(cache != null) cache.put(subject.getPrincipal().toString(), userToken);
			}
			
			return false;
		}
		
		//存放菜单数据到session中
		MenuTreeService menuService = ApplicationContextUtils.getBean("menuTreeService", MenuTreeService.class);
		if(menuService != null) {
			session.setAttribute("treeMenu", menuService.getMenu(1));
		}
		
		return super.onLoginSuccess(token, subject, request, response);
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		
		Device device = DeviceUtils.getCurrentDevice(WebUtils.toHttp(request));
		if(!device.isNormal()) {//因为是浏览器查看，所以这里会为true
			JSONObject resultJson = new JSONObject();
			resultJson.put(WebConfig.IS_LOGGED, false);
			resultJson.put(WebConfig.USER_TOKEN_SESSION_KEY, "");
			resultJson.put(ShiroHttpSession.DEFAULT_SESSION_ID_NAME,"");
			try {
				response.getWriter().write(resultJson.toString());
				response.getWriter().flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		
		return super.onLoginFailure(token, e, request, response);
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		Subject subject = SecurityUtils.getSubject();
		Device device = DeviceUtils.getCurrentDevice(WebUtils.toHttp(request));
		if(!device.isNormal()) {//因为是浏览器查看，所以这里会为true
			if(subject.isAuthenticated()) return true;
			
			//从缓存中获取token
			String userToken = "";
			String userName = request.getParameter(WebConfig.USER_NAME_REQUEST_KEY);
			EhCacheManager cacheManager = ApplicationContextUtils.getBean("cacheManager", EhCacheManager.class);
			if(cacheManager != null) {
				Cache<String,Object> cache = cacheManager.getCache(WebConfig.USER_TOKEN_CACHE_NAME);
				if(cache != null) userToken = (String)cache.get(userName); 
			}
			//如果缓存中存在userToken,则从表中查询用户密码并登录
			if(!StringUtils.isEmpty(userToken)) {
				UsernamePasswordToken token = new UsernamePasswordToken(userName, "abc123");//应该从服务器获取密码
				
				try {
		            subject.login(token);
		            return onLoginSuccess(token, subject, request, response);
		        } catch (AuthenticationException e) {
		            return onLoginFailure(token, e, request, response);
		        } catch (Exception e) {
		        	e.printStackTrace();
				}
			}
		}
		
		return super.isAccessAllowed(request, response, mappedValue);
	}
	
	
}
