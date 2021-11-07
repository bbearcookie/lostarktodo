package com.lostarktodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostarktodo.domain.ScheduleTypeDTO;
import com.lostarktodo.mapper.ScheduleTypeMapper;

@Service
public class ScheduleTypeServiceImpl implements ScheduleTypeService {
	
	@Autowired
	private ScheduleTypeMapper scheduleTypeMapper;
	

	public List<ScheduleTypeDTO> selectScheduleTypeList() {
		List<ScheduleTypeDTO> list = scheduleTypeMapper.selectScheduleTypeList();
		
		return list;
	}

}
