package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.AuthMapper;
import com.example.demo.model.Auth;

/**
 * 权限Service
 * @author yanzhiying
 *
 */
@Service
public class AuthService {
	
	@Autowired
	private AuthMapper authMapper;
	
	
	public Auth queryAuthById(String authId){
		return authMapper.queryAuthById(authId);
	}
	
	
	
	
	
	
	public AuthMapper getAuthMapper() {
		return authMapper;
	}

	public void setAuthMapper(AuthMapper authMapper) {
		this.authMapper = authMapper;
	}
	
}
