package com.lostarktodo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lostarktodo.domain.HeroTypeDTO;

@Mapper
public interface HeroTypeMapper {
	public List<HeroTypeDTO> selectHeroTypeList();
}