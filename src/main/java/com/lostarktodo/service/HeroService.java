package com.lostarktodo.service;

import java.util.List;

import com.lostarktodo.domain.HeroDTO;

public interface HeroService {
	public int createHero(HeroDTO params);
	public List<HeroDTO> selectHeroListAndHeroTypeByUseridx(int userIdx);
}
