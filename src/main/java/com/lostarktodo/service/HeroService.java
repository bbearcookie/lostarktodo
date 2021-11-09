package com.lostarktodo.service;

import java.util.List;

import com.lostarktodo.domain.HeroDTO;

public interface HeroService {
	public int registerHero(HeroDTO params);
	public HeroDTO getHero(int heroIdx);
	public boolean deleteHero(int idx);
	public List<HeroDTO> selectHeroListAndHeroTypeByUseridx(int userIdx);
}
