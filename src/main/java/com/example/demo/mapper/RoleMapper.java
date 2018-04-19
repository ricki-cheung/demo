package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Role;

/**
 * 
 * @author yanzhiying
 *mybatis的Mapper相当于Dao层
 */
@Mapper
public interface RoleMapper {
	Role getRoleById(@Param("roleId") Integer roleId);
}
