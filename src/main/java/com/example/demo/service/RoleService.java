package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.RoleMapper;
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

	
	
	public Role getRoleById(Integer roleId) {
		return roleMapper.getRoleById(roleId);
	}
	
	
	
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
	
	
	
}
