/**
 * 
 */
package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Auth;

/**
 * @author yanzhiying
 * mybatis的Mapper相当于Dao层
 */
@Mapper
public interface AuthMapper {
	Auth queryAuthById(String authId);
}
