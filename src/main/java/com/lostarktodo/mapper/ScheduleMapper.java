package com.lostarktodo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.ScheduleDTO;

@Mapper
public interface ScheduleMapper {
	public int insertSchedule(ScheduleDTO params);
	public ScheduleDTO selectScheduleDetail(int idx);
	public int updateSchedule(ScheduleDTO params);
	public int deleteSchedule(int idx);
	public List<ScheduleDTO> selectScheduleList();
	public List<ScheduleDTO> selectDailyScheduleListByHeroidx(int heroIdx);
	public List<ScheduleDTO> selectDailyScheduleListAndScheduleTypeByHeroidx(int heroIdx);
	public List<ScheduleDTO> selectWeeklyScheduleListByHeroidx(int heroIdx);
	public List<ScheduleDTO> selectWeeklyScheduleListAndScheduleTypeByHeroidx(int heroIdx);
}
