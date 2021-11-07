package com.lostarktodo.service;

import java.util.List;

import com.lostarktodo.domain.ScheduleDTO;

public interface ScheduleService {
	public boolean registerSchedule(ScheduleDTO params);
	public List<ScheduleDTO> selectDailyScheduleListAndScheduleTypeByHeroidx(int heroIdx);
	public List<ScheduleDTO> selectWeeklyScheduleListAndScheduleTypeByHeroidx(int heroIdx);
}
