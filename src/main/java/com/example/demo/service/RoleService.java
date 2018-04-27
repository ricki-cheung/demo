package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.AuthMapper;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.model.Auth;
import com.example.demo.model.Role;

/**
 * 
 * @author yanzhiying
 *
 */
@Service
public class RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private AuthMapper authMapper;
	
	/**
	 * 根据角色ID查询所有的权限
	 * @param roleId
	 * @return
	 */
	public List<Auth> getAuthByRoleId(Integer roleId){
		return authMapper.getAuthByRoleId(roleId);
	}
	
	
	
	
	public Role getRoleById(Integer roleId) {
		return roleMapper.getRoleById(roleId);
	}
	
	public List<Role> getRoleListByAuthId(String authId){
		return roleMapper.getRoleListByAuthId(authId);
	}
	
	
	
	
	
	
}
