package com.lostarktodo.service;

import java.util.List;

import com.lostarktodo.domain.HeroDTO;

// 캐릭터에 관한 비즈니스 로직을 담은 클래스.
public interface HeroService {
	public int registerHero(HeroDTO params); // 캐릭터의 정보를 업데이트하거나 새로 생성
	public HeroDTO getHero(int heroIdx); // 캐릭터의 정보 조회
	public boolean deleteHero(int idx); // 캐릭터 제거
	public List<HeroDTO> selectHeroListAndHeroTypeByUseridx(int userIdx); // 특정 유저가 가지고 있는 모든 캐릭터 반환
}
