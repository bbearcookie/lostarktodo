package com.lostarktodo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lostarktodo.domain.HeroDTO;

@Mapper
public interface HeroMapper {
	public int insertHero(HeroDTO params);
	public int updateHero(HeroDTO params);
	public int deleteHero(int idx);
	public List<HeroDTO> selectHeroListByUseridx(int userIdx);
	public List<HeroDTO> selectHeroListAndHeroTypeByUseridx(int userIdx);
}
