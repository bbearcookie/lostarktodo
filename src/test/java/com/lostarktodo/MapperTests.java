package com.lostarktodo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lostarktodo.domain.HeroTypeDTO;
import com.lostarktodo.mapper.HeroTypeMapper;
import com.lostarktodo.mapper.UserMapper;

@SpringBootTest
public class MapperTests {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private HeroTypeMapper heroTypeMapper;
	
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
	
//	@Test
//	public void testOfFindByUsername() {
//		UserDTO user = userMapper.findByUsername("aodem");
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
	public void testOfPrintAllHeroType() {
		List<HeroTypeDTO> list = heroTypeMapper.selectHeroTypeList();
		
		for (HeroTypeDTO e : list) {
			System.out.println(e.toString());
		}
	}
}
