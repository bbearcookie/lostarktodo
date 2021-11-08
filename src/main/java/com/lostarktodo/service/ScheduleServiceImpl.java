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
	
	public List<ScheduleDTO> selectDailyScheduleListAndScheduleTypeByHeroidx(int scheduleIdx) {
		List<ScheduleDTO> list = scheduleMapper.selectDailyScheduleListAndScheduleTypeByHeroidx(scheduleIdx);
		return list;
	}
	
	public List<ScheduleDTO> selectWeeklyScheduleListAndScheduleTypeByHeroidx(int scheduleIdx) {
		List<ScheduleDTO> list = scheduleMapper.selectWeeklyScheduleListAndScheduleTypeByHeroidx(scheduleIdx);
		return list;
	}
	
	public ScheduleDTO increaseCompleteSchedule(int scheduleIdx) {
		ScheduleDTO params = scheduleMapper.selectScheduleDetail(scheduleIdx);
		
		if (params != null) {
			// completeCount를 1 증가시켰을때 최대치를 초과하게되면 0으로 만든다.
			if (params.getCompleteCount() + 1 <= params.getMaxCompleteCount()) {
				params.setCompleteCount(params.getCompleteCount() + 1);
			} else {
				params.setCompleteCount(0);
			}
			
			scheduleMapper.updateSchedule(params);
		}
		
		return params;
	}
	
	public ScheduleDTO getSchedule(int scheduleIdx) {
		return scheduleMapper.selectScheduleDetail(scheduleIdx);
	}
}
