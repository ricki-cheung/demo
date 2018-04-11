/**
 * 
 */
package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PatientInfoMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.PatientInfo;
import com.example.demo.model.User;

/**
 * @author Ricki
 *
 */
@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	
	/**
	 * 查询用户列表数据
	 * @return
	 */
	public List<User> queryList(Map<String,Object> paramMap){
		return userMapper.queryUserList(paramMap);
	}


	public UserMapper getUserMapper() {
		return userMapper;
	}


	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}



	
	
	

}
