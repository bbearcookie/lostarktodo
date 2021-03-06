package com.lostarktodo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lostarktodo.domain.ScheduleDTO;
import com.lostarktodo.mapper.HeroMapper;
import com.lostarktodo.mapper.HeroTypeMapper;
import com.lostarktodo.mapper.ScheduleMapper;
import com.lostarktodo.mapper.ScheduleTypeMapper;
import com.lostarktodo.mapper.UserMapper;
import com.lostarktodo.service.HeroService;

@SpringBootTest
public class MapperTests {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private HeroTypeMapper heroTypeMapper;
	
	@Autowired
	private HeroMapper heroMapper;
	
	@Autowired
	private ScheduleTypeMapper scheduleTypeMapper;
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@Autowired
	private HeroService heroService;
	
//	@Test
//	public void testOfInsert() {
//		UserDTO params = new UserDTO();
//		params.setUsername("테스트계정");
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
	
//	@Test
//	public void testOfPrintAllHeroType() {
//		List<HeroTypeDTO> list = heroTypeMapper.selectHeroTypeList();
//		
//		for (HeroTypeDTO e : list) {
//			System.out.println(e.toString());
//		}
//	}
	
//	@Test
//	public void testOfInsertHero() {
//		HeroDTO params = new HeroDTO();
//		params.setIdx(0);
//		params.setName("테스트용");
//		params.setTypeIdx(1);
//		params.setUserIdx(1);
//		
//		int result = heroMapper.insertHero(params);
//		System.out.println("testOfInsert 결과: " + result);
//	}
	
//	@Test
//	public void testOfUpdateHero() {
//		HeroDTO params = new HeroDTO();
//		params.setIdx(1);
//		params.setName("수정기능테스트");
//		params.setTypeIdx(4);
//		
//		int result = heroMapper.updateHero(params);
//		System.out.println("testOfInsert 결과: " + result);
//	}
	
//	@Test
//	public void testOfDeleteHero() {
//		int result = heroMapper.deleteHero(1);
//	}
	
//	@Test
//	public void testOfSelectHeroListByUseridx() {
//		List<HeroDTO> list = heroMapper.selectHeroListByUseridx(1);
//
//		for (HeroDTO e : list) {
//			System.out.println(e.toString());
//		}
//	}
	
//	@Test
//	public void testOfHeroSelect() {
//		HeroDTO hero = heroMapper.selectHeroDetail(2);
//		System.out.println(hero);
//	}
	
//	@Test
//	public void testOfGson() {
//		HeroDTO params = heroService.getHero(1);
//		
//		ObjectMapper objMapper = new ObjectMapper();
//		
//		try {
//			String jsonInString = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(params);
//			System.out.println(jsonInString);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		
////		JsonObject jsonObject = new JsonObject();
////		jsonObject.addProperty("idx", params.getIdx());
////		jsonObject.addProperty("name", params.getName());
////		jsonObject.addProperty("typeIdx", params.getTypeIdx());
////		jsonObject.addProperty("userIdx", params.getUserIdx());
////		jsonObject.addProperty("disabled", params.getDisabled());
////		String jsonStr = gson.toJson(jsonObject);
////		System.out.println(jsonStr);
////		System.out.println(params);
//	}
	
//	@Test
//	public void testOfScheduleType() {
//		List<ScheduleTypeDTO> list = scheduleTypeMapper.selectScheduleTypeList();
//		System.out.println(list);
//	}
	
//	@Test
//	public void testOfInsertSchedule() {
//		ScheduleDTO params = new ScheduleDTO();
//		params.setIdx(0);
//		params.setName("주간테스트");
//		params.setPeriod("W");
//		params.setRestingGauge(0);
//		params.setMaxRestingGauge(100);
//		params.setCompleteCount(0);
//		params.setMaxCompleteCount(2);
//		params.setTypeIdx(1);
//		params.setHeroIdx(2);
//		
//		scheduleMapper.insertSchedule(params);
//	}
	
//	@Test
//	public void testOfUpdateSchedule() {
//		ScheduleDTO params = scheduleMapper.selectScheduleDetail(1);
//		System.out.println(params);
//		
//		params.setRestingGauge(40);
//		scheduleMapper.updateSchedule(params);
//	}
	
//	@Test
//	public void testOfDeleteSchedule() {
//		scheduleMapper.deleteSchedule(1);
//	}
	
//	@Test
//	public void testOfSeekDailySchedule() {
//		List<ScheduleDTO> list = scheduleMapper.selectDailyScheduleListByHeroidx(1);
//		System.out.println(list);
//	}
	
//	@Test
//	public void testOfSeekWeeklySchedule() {
//		List<ScheduleDTO> list = scheduleMapper.selectWeeklyScheduleListByHeroidx(1);
//		System.out.println(list);
//	}
	
//	@Test
//	public void testOfSelectDailyScheduleListAndScheduleTypeByHeroidx() {
//		List<ScheduleDTO> list = scheduleMapper.selectScheduleList();
//		System.out.println(list);
//	}
}
