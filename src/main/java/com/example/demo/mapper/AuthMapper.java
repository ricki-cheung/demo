package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Auth;

/**
 * @author yanzhiying
 * mybatis的Mapper相当于Dao层
 */
@Mapper
public interface AuthMapper {
	Auth queryAuthById(@Param(value="authId") String authId);
	
	/**
	 * 根据角色ID查询所有的相应权限
	 * @param roleId
	 * @return
	 */
	List<Auth> getAuthByRoleId(Integer roleId);
}
