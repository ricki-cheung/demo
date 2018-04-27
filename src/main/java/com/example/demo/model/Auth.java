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
	private String authParent;
	private Integer authType;
	private String authEntry;
	private String authPath;
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
	public String getAuthParent() {
		return authParent;
	}
	public void setAuthParent(String authParent) {
		this.authParent = authParent;
	}
	public Integer getAuthType() {
		return authType;
	}
	public void setAuthType(Integer authType) {
		this.authType = authType;
	}
	public String getAuthEntry() {
		return authEntry;
	}
	public void setAuthEntry(String authEntry) {
		this.authEntry = authEntry;
	}
	public String getAuthPath() {
		return authPath;
	}
	public void setAuthPath(String authPath) {
		this.authPath = authPath;
	}
	
	
	
	
	
	
}
