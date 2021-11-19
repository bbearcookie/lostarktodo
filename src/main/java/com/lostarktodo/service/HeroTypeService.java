package com.lostarktodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lostarktodo.domain.HeroTypeDTO;

// 캐릭터 타입에 관한 비즈니스 로직을 담은 클래스
public interface HeroTypeService {
	public List<HeroTypeDTO> getAllHeroType(); // DB에 있는 모든 캐릭터 타입을 반환함.
}
