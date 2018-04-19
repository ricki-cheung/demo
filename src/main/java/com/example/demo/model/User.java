package com.example.demo.model;

import java.util.List;

/**
 * 
 * @author yanzhiying
 *sys_user表
 */
public class User {
	private Integer id;
	private String userName;
	private String passWord;
	private List<Role> roleList;//一个用户拥有多个角色
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	
}
