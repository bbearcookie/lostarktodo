package com.lostarktodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.ScheduleDTO;
import com.lostarktodo.mapper.ScheduleMapper;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	public boolean registerSchedule(ScheduleDTO params) {
		int queryResult = 0;
		
		if (params.getIdx() == 0) {
			queryResult = scheduleMapper.insertSchedule(params);
		} else {
			queryResult = scheduleMapper.updateSchedule(params);
		}
		
		return (queryResult == 1);
	}
	
	public List<ScheduleDTO> selectDailyScheduleListAndScheduleTypeByHeroidx(int heroIdx) {
		List<ScheduleDTO> list = scheduleMapper.selectDailyScheduleListAndScheduleTypeByHeroidx(heroIdx);
		return list;
	}
	
	public List<ScheduleDTO> selectWeeklyScheduleListAndScheduleTypeByHeroidx(int heroIdx) {
		List<ScheduleDTO> list = scheduleMapper.selectWeeklyScheduleListAndScheduleTypeByHeroidx(heroIdx);
		return list;
	}
}
