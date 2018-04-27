package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Auth;
import com.example.demo.service.MenuTreeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Ricki
 *
 */
@Controller
public class IndexController {
	
	@Autowired
	private MenuTreeService menuTreeService;

	/**
	 * @return
	 * 登录成功后的首页页面
	 */
	@RequestMapping("/index")
	public String indexPage(Model model,@RequestParam(defaultValue="1") Integer id) {
		List<Auth> authList = menuTreeService.getAuthByUserId(id);//查询权限
		List<Auth> menuAuth = menuTreeService.getMenuAuth(authList);//找出菜单权限
		List<Auth> topMenuAuth = menuTreeService.getTopMenuAuth(authList);//找出顶级菜单权限
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
		model.addAttribute("treeMenu", allJsonArray);
		return "index";
		//return allJsonArray;
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
