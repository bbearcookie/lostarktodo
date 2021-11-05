package com.lostarktodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lostarktodo.domain.HeroTypeDTO;

public interface HeroTypeService {
	public List<HeroTypeDTO> getAllHeroType();
}
