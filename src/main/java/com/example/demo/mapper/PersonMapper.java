/**
 * 
 */
package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.PatientInfo;
import com.example.demo.model.Person;

/**
 * @author yanzhiying
 * mybatis的Mapper相当于Dao层
 */
@Mapper
public interface PersonMapper {
	Person queryPersonforName(String name);
	void addPatient(String name);
}
