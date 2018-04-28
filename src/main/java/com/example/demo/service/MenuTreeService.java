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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	 * 根据用户ID返回对应的JSON格式的菜单
	 * @param id
	 * @return
	 */
	public JSONArray getMenu(Integer id) {
		List<Auth> authList = this.getAuthByUserId(id);//查询权限
		List<Auth> menuAuth = this.getMenuAuth(authList);//找出菜单权限
		List<Auth> topMenuAuth = this.getTopMenuAuth(authList);//找出顶级菜单权限
		Map<String, Auth> authMap = new HashMap<>();
		JSONArray allJsonArray = new JSONArray();
		JSONArray jsonArray = null;
		
		//循环把顶级菜单的父菜单传进去
		for (Auth auth : topMenuAuth) {
			//传进去之前应该判断之前是不是已经传过一样的父ID了,确保不会重复传同样的父ID进去
			if(authMap.get(auth.getAuthParent()) == null) {
				jsonArray = authMenu(menuAuth, auth.getAuthParent());
				authMap.put(auth.getAuthParent(), auth);//map<父ID，auth>
				if(jsonArray != null && jsonArray.size()!=0) {				
					allJsonArray.addAll(jsonArray);
				}
			}
		}
		return allJsonArray;
	}
	
	/**
	 * 根据用户名返回对应的JSON格式的菜单
	 * @param userName
	 * @return
	 */
	public JSONArray getMenuByUserName(String userName) {
		User user = userMapper.getUserByUserName(userName);
		return getMenu(user.getId());
	}
	
	/**
	 * 生成菜单树
	 * @param authList
	 * @param parentId  顶级菜单的父ID
	 * @return
	 */
	private  JSONArray authMenu(List<Auth> authList,String parentId) {
		JSONArray childMenu = new JSONArray();
		for (Auth menu : authList) {
			 if (parentId.equals(menu.getAuthParent())) {//从顶级菜单开始递归
				 JSONObject jo = (JSONObject) JSONObject.fromObject(menu);
				 JSONArray c_node = authMenu(authList, menu.getId());
				 jo.put("children", c_node);
				 childMenu.add(jo);
			 }
		}
		return childMenu;
}
	
}
