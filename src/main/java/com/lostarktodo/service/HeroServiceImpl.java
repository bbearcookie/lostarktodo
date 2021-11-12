package com.lostarktodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.ScheduleDTO;
import com.lostarktodo.mapper.HeroMapper;

@Service
public class HeroServiceImpl implements HeroService {
	
	@Autowired
	private HeroMapper heroMapper;
	
	@Autowired
	private ScheduleService scheduleService;
	
	public int registerHero(HeroDTO params) {
		int queryResult = 0;
		
		if (params.getIdx() == 0) {
			queryResult = heroMapper.insertHero(params);
			
			// 캐릭터를 처음 생성하면 일일 스케줄로 카오스 던전, 가디언 토벌, 에포나 3종은 기본으로 추가해준다.
			ScheduleDTO schedule;
			schedule = new ScheduleDTO();
			schedule.setIdx(0);
			schedule.setName("카오스 던전");
			schedule.setPeriod("D");
			schedule.setTypeIdx(1);
			schedule.setRestingGauge(0);
			schedule.setMaxRestingGauge(100);
			schedule.setCompleteCount(0);
			schedule.setMaxCompleteCount(2);
			schedule.setHeroIdx(params.getIdx());
			schedule.setDisabled("N");
			schedule.setScheduleTypeDTO(null);
			scheduleService.registerSchedule(schedule);

			schedule = new ScheduleDTO();
			schedule.setIdx(0);
			schedule.setName("가디언 토벌");
			schedule.setPeriod("D");
			schedule.setTypeIdx(2);
			schedule.setRestingGauge(0);
			schedule.setMaxRestingGauge(100);
			schedule.setCompleteCount(0);
			schedule.setMaxCompleteCount(2);
			schedule.setHeroIdx(params.getIdx());
			schedule.setDisabled("N");
			schedule.setScheduleTypeDTO(null);
			scheduleService.registerSchedule(schedule);
			
			schedule = new ScheduleDTO();
			schedule.setIdx(0);
			schedule.setName("에포나");
			schedule.setPeriod("D");
			schedule.setTypeIdx(4);
			schedule.setRestingGauge(0);
			schedule.setMaxRestingGauge(100);
			schedule.setCompleteCount(0);
			schedule.setMaxCompleteCount(3);
			schedule.setHeroIdx(params.getIdx());
			schedule.setDisabled("N");
			schedule.setScheduleTypeDTO(null);
			scheduleService.registerSchedule(schedule);
		} else {
			queryResult = heroMapper.updateHero(params);
		}
		
		return params.getIdx(); // 생성된 캐릭터의 idx를 반환함.
	}
	
	public HeroDTO getHero(int heroIdx) {
		return heroMapper.selectHeroDetail(heroIdx);
	}
	
	public boolean deleteHero(int idx) {
		int queryResult = 0;
		
		HeroDTO hero = heroMapper.selectHeroDetail(idx);
		
		if (hero != null && "N".equals(hero.getDisabled())) {
			queryResult = heroMapper.deleteHero(idx);
		}
		
		return (queryResult == 1);
	}
	
	public List<HeroDTO> selectHeroListAndHeroTypeByUseridx(int userIdx) {
		return heroMapper.selectHeroListAndHeroTypeByUseridx(userIdx);
	}
}
