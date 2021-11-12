package com.lostarktodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostarktodo.domain.GlobalVariables;
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
	
	public boolean deleteSchedule(int idx) {
		int queryResult = 0;
		
		ScheduleDTO schedule = scheduleMapper.selectScheduleDetail(idx);
		
		if (schedule != null && "N".equals(schedule.getDisabled())) {
			queryResult = scheduleMapper.deleteSchedule(idx);
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
	
	// 스케줄들의 완료 횟수에 따라 휴식 게이지를 계산하고 완료 횟수를 초기화함.
	public void calculateRestingGauge() {
		List<ScheduleDTO> list = scheduleMapper.selectScheduleList();
		int scheduleResetCycle = GlobalVariables.getScheduleResetCycle();
		
		for (ScheduleDTO schedule : list) {
			// 일간 스케줄
			if (schedule.getPeriod().equals("D")) {
				// 휴식 게이지의 최소치는 0, 최대치는 100이다.
				// 감소: 스케줄의 완료 횟수에 따라 휴식 게이지가 20씩 소모된다.
				// 증가: 그리고 (최대 완료 횟수 - 완료 횟수) * 10만큼 휴식 게이지를 증가시킨다.
				int completeCount = schedule.getCompleteCount();
				int maxCompleteCount = schedule.getMaxCompleteCount();
				int restingGauge = schedule.getRestingGauge();
				restingGauge -= completeCount * 20; // 휴식 게이지 감소
				restingGauge += (maxCompleteCount - completeCount) * 10; // 휴식 게이지 증가
				
				// 값 범위 초과시 보정
				if (restingGauge < 0) restingGauge = 0;
				else if (restingGauge > 100) restingGauge = 100;

				schedule.setRestingGauge(restingGauge);
				schedule.setCompleteCount(0);
				scheduleMapper.updateSchedule(schedule);
				
			// 주간 스케줄
			} else if (schedule.getPeriod().equals("W") && scheduleResetCycle >= 6) {
				schedule.setCompleteCount(0);
				scheduleMapper.updateSchedule(schedule);
			}
		}
		
		GlobalVariables.increaseScheduleResetCycle();
	}
}
