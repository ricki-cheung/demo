/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Role;
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
	public User queryUserById(int id){
		return userMapper.queryUserById(id);
	}


	public UserMapper getUserMapper() {
		return userMapper;
	}


	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}



	
	
	

}
