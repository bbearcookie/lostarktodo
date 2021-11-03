package com.lostarktodo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.mapper.UserMapper;

@SpringBootTest
public class MapperTests {

	@Autowired
	private UserMapper userMapper;
	
//	@Test
//	public void testOfInsert() {
//		UserDTO params = new UserDTO();
//		params.setUserid("1번계정");
//		params.setPassword("1234");
//		
//		int result = userMapper.insertUser(params);
//		System.out.println("testOfInsert 결과: " + result);
//	}
//	
//	@Test
//	public void testOfSelectDetail() {
//		UserDTO user = userMapper.selectUserDetail((long)1);
//		try {
//			String userJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(user);
//			System.out.println("======================");
//			System.out.println(userJson);
//			System.out.println("======================");
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testOfFindByUsername() {
		UserDTO user = userMapper.findByUsername("aodem");
		try {
			String userJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(user);
			System.out.println("======================");
			System.out.println(userJson);
			System.out.println("======================");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
