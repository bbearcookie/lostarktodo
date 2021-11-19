package com.lostarktodo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lostarktodo.domain.HeroDTO;

// Hero 테이블에 대한 쿼리문을 모은 인터페이스
@Mapper
public interface HeroMapper {
	public int insertHero(HeroDTO params); // 캐릭터 추가
	public HeroDTO selectHeroDetail(int idx); // 캐릭터 조회
	public int updateHero(HeroDTO params); // 캐릭터 수정
	public int deleteHero(int idx); // 캐릭터 제거
	public List<HeroDTO> selectHeroListByUseridx(int userIdx); // 특정 유저가 가진 모든 캐릭터 조회
	public List<HeroDTO> selectHeroListAndHeroTypeByUseridx(int userIdx); // 특정 유저가 가진 모든 캐릭터를 HeroType 테이블과 JOIN한 형태로 조회
}
