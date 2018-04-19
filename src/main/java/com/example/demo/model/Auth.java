package com.example.demo.model;

import java.util.List;

/**
 * 
 * @author yanzhiying
 *sys_auth表
 */
public class Auth {
	private String id;
	private String authName;
	private List<Role> roleList;//一个权限对应多个角色
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	
	
	
	
	
}
