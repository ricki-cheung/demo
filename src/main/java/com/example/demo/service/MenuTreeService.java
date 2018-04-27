package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Auth;
import com.example.demo.model.Role;
import com.example.demo.model.User;

@Service
public class MenuTreeService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleService roleService;
	
	/**
	 * 查询用户拥有的角色
	 * @param userId
	 * @return Map<String, Role>
	 */
	private  List<Role> getRoleListByUserId(Integer userId) {
		 User user = userMapper.queryUserById(userId);
		return user.getRoleList();
	}
	
	
	
	
	
	/**
	 * 根据用户ID查询所有的权限
	 * @param userId
	 * @return
	 */
	public List<Auth> getAuthByUserId(Integer userId){
		List<Role> roleList = getRoleListByUserId(userId);
		List<Auth> authList = new ArrayList<>();
		Map<String,Auth> authMap = new HashMap<>();
		if(roleList == null) return authList;
		if(roleList.size() == 1) {
			authList = roleService.getAuthByRoleId(roleList.get(0).getId());
		}else if(roleList.size()>1) {
			for (Role role : roleList) {
				List<Auth> auths = roleService.getAuthByRoleId(role.getId());
				if(auths!= null && auths.size()>0) {
					for (Auth auth : auths) {
						if(authMap.get(auth.getAuthName())==null) {
							authMap.put(auth.getAuthName(), auth);
						}
					}
				}
			}
			
			for (Map.Entry<String, Auth> entry: authMap.entrySet()) {
				authList.add(entry.getValue());
			}
		}
		return authList;
	}
	
	
	/**
	 * 找出菜单栏的auth列表
	 * @param authList 所有权限
	 * @return
	 */
	public List<Auth> getMenuAuth(List<Auth> authList){
		List<Auth> authMenu = new ArrayList<>();
		for (Auth auth : authList) {
			if(auth.getAuthType() == 1 || auth.getAuthType() == 2) {
				authMenu.add(auth);
			}
		}
		return authMenu;

	}
	
	/**
	 * 找出顶级菜单
	 * @param authList
	 * @return
	 */
	public List<Auth> getTopMenuAuth(List<Auth> authList){
		List<Auth> topMenuAuth = new ArrayList<>();
		for (Auth auth : authList) {
			if(auth.getAuthType() == 1 && auth.getAuthParent() != null) {
				topMenuAuth.add(auth);
			}
		}
		return topMenuAuth;
	}
	
	
	
	/**
	 * 查询用户的权限
	 */
	/*public List<Auth> getAuthListByUserId(Integer userId) {
		List<Role> roleList = getRoleListByUserId(userId);
		Map<String,Auth> authMap = new HashMap<>();
		List<Auth> authList = new ArrayList<>();
		for (Role role : roleList) {
			for (Auth auth : role.getAuthList()) {
				if(authMap.get(auth.getAuthName()) == null) {
					authMap.put(auth.getAuthName(), auth);
				}
			}
		}
		for (Map.Entry<String, Auth> entry : authMap.entrySet()) {
			authList.add(entry.getValue());
		}
		return authList;
	}*/
	
}
