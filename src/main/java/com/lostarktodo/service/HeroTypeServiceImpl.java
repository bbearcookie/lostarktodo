package com.lostarktodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostarktodo.domain.HeroTypeDTO;
import com.lostarktodo.mapper.HeroTypeMapper;

@Service
public class HeroTypeServiceImpl implements HeroTypeService {
	
	@Autowired
	private HeroTypeMapper heroTypeMapper;
	
	public List<HeroTypeDTO> getAllHeroType() {
		return heroTypeMapper.selectHeroTypeList();
	}
}
