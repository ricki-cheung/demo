package com.example.demo.model;

import java.util.List;

/**
 * 
 * @author yanzhiying
 *	sys_role表
 */
public class Role {
	
	private Integer id;
	private String roleName;
	private List<User> userList;//一个角色对应多个用户
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
