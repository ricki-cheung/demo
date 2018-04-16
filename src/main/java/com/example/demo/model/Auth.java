package com.example.demo.model;

/**
 * 
 * @author yanzhiying
 *sys_auth表
 */
public class Auth {
	private String id;
	private String name;
	private String roleId;//一个权限对应一个角色
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
	
}
