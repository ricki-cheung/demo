package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PersonMapper;

@Service
public class PersonService {
	@Autowired
	private PersonMapper personMapper;
	/**
	 * 根据名字查询病人流水号
	 * @param name
	 * @return
	 */
	/*public Person queryPersonforName(String name) {
		return personMapper.queryPersonforName(name);
	}*/
	
	/**
	 * 新增person
	 * @param name
	 */
	/*public void addPatient(String name) {
		personMapper.addPatient(name);
	}*/
	
	/**
	 * 修改person名字
	 * @param paramMap
	 */
	/*public void updatePerson(Map<String, Object> paramMap) {
		personMapper.updatePerson(paramMap);
	}*/
}
