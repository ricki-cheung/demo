package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

/**
 * @author yanzhiying
 *
 */
@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	
	/**
	 * 查询用户数据
	 * @return
	 */
	public User queryUserById(Integer userId){
		return userMapper.queryUserById(userId);
	}


	/**
	 * 根据角色ID查询拥有该角色的用户
	 * @param roleId
	 * @return	List<User>
	 */
	public List<User> getUserListByRoleId(Integer roleId){
		return userMapper.getUserListByRoleId(roleId);
	}
	
	
	
	



	
	
	

}
