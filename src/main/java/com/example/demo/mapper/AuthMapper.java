/**
 * 
 */
package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Auth;

/**
 * @author yanzhiying
 * mybatis的Mapper相当于Dao层
 */
@Mapper
public interface AuthMapper {
	Auth queryAuthById(@Param("authId") String authId);
}
