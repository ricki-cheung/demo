/**
 * 
 */
package com.example.demo.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;

/**
 * @author yanzhiying
 * mybatis的Mapper相当于Dao层
 */
@Mapper
public interface UserMapper {
	User queryUserById(@Param(value="userId") Integer userId);
	List<User> getUserListByRoleId(@Param(value="roleId") Integer roleId);
}
