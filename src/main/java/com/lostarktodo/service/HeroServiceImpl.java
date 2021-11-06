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
	
	public int createHero(HeroDTO params) {
		return heroMapper.insertHero(params);
	}
	
	public List<HeroDTO> selectHeroListAndHeroTypeByUseridx(int userIdx) {
		return heroMapper.selectHeroListAndHeroTypeByUseridx(userIdx);
	}
}
