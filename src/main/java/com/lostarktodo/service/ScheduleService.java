package com.lostarktodo.service;

import java.util.List;

import com.lostarktodo.domain.ScheduleDTO;

public interface ScheduleService {
	public boolean registerSchedule(ScheduleDTO params);
	public List<ScheduleDTO> selectDailyScheduleListAndScheduleTypeByHeroidx(int scheduleIdx);
	public List<ScheduleDTO> selectWeeklyScheduleListAndScheduleTypeByHeroidx(int scheduleIdx);
	public ScheduleDTO increaseCompleteSchedule(int scheduleIdx);
}
