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
	
	public boolean registerHero(HeroDTO params) {
		int queryResult = 0;
		
		if (params.getIdx() == 0) {
			queryResult = heroMapper.insertHero(params);
		} else {
			queryResult = heroMapper.updateHero(params);
		}
		
		return (queryResult == 1);
	}
	
	public HeroDTO getHero(int heroIdx) {
		return heroMapper.selectHeroDetail(heroIdx);
	}
	
	public List<HeroDTO> selectHeroListAndHeroTypeByUseridx(int userIdx) {
		return heroMapper.selectHeroListAndHeroTypeByUseridx(userIdx);
	}
}
