package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.RoleMapper;
import com.example.demo.model.Auth;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import com.example.demo.service.MenuTreeService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;


@Controller
public class TestController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MenuTreeService menuTreeService;
	
	@RequestMapping("/testUser")
	@ResponseBody
	public User queryUserById(Integer userId) {
		return  userService.queryUserById(userId);	 
	}
	
	
	@RequestMapping("/testUserList")
	@ResponseBody
	public List<User> getUserListByRoleId(Integer roleId){
		return userService.getUserListByRoleId(roleId);
	}
	
	
	@RequestMapping("/testAuth")
	@ResponseBody
	public Auth queryAuthById(String authId) {
		return authService.queryAuthById(authId);	
	}
	
	
	
	@RequestMapping("/testRole")
	@ResponseBody
	public Role getRoleById(int roleId) {
		return  roleService.getRoleById(roleId);
	}
	
	
	@RequestMapping("/testRoleList")
	@ResponseBody
	public List<Role> getRoleListByAuthId(String authId){
		return roleService.getRoleListByAuthId(authId);
	}
	
	
	
	/*@RequestMapping("/testRoleById")
	public ModelAndView  testMenu() {
		List<Auth> authList = roleMapper.getRoleById(1).getAuthList();
		ModelAndView modelAndView = new ModelAndView("menu");
		JSONArray ja = authMenu(authList, "SysMgr");
		System.out.println(ja.toString());
		modelAndView.addObject("treeMenu", ja);
		return modelAndView;

	}
	
	@RequestMapping("/aaa")
	public String getAuth(Model model){
	
		model.addAttribute("authList", roleMapper.getRoleById(1).getAuthList());
		return  "menu";
		
	}
	
	public JSONArray authMenu(List<Auth> authList,String parentId) {
			JSONArray childMenu = new JSONArray();
			for (Auth menu : authList) {
				 if (parentId.equals(menu.getAuthParent())) {
					 JSONObject jo = (JSONObject) JSONObject.fromObject(menu);
					 JSONArray c_node = authMenu(authList, menu.getId());
					 jo.put("children", c_node);
					 childMenu.add(jo);
				 }
			}
			return childMenu;
	}
	*/
	
	/*@RequestMapping("/bbb")
	public String testUseMenu(Model model) {
		List<Auth> authList = menuTreeService.getAuthListByUserId(1);
		JSONArray ja = authMenu(authList, "SysMgr");
		model.addAttribute("treeMenu", ja);
		return "menu";
	}*/
	
	
	
	
	
}
