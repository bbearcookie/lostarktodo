package com.lostarktodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostarktodo.domain.HeroDTO;
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
