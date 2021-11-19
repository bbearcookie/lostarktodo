package com.lostarktodo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.ScheduleDTO;

// Schedule 테이블에 대한 쿼리문을 모은 인터페이스
@Mapper
public interface ScheduleMapper {
	public int insertSchedule(ScheduleDTO params); // 스케줄 추가
	public ScheduleDTO selectScheduleDetail(int idx); // 스케줄 조회
	public int updateSchedule(ScheduleDTO params); // 스케줄 수정
	public int deleteSchedule(int idx); // 스케줄 제거
	public List<ScheduleDTO> selectScheduleList(); // 모든 스케줄 조회
	public List<ScheduleDTO> selectDailyScheduleListByHeroidx(int heroIdx); // 특정 캐릭터가 가진 모든 일간 스케줄을 조회
	public List<ScheduleDTO> selectDailyScheduleListAndScheduleTypeByHeroidx(int heroIdx); // 특정 캐릭터가 가진 모든 일간 스케줄을 ScheduleType 테이블과 JOIN한 형태로 조회
	public List<ScheduleDTO> selectWeeklyScheduleListByHeroidx(int heroIdx); // 특정 캐릭터가 가진 모든 주간 스케줄을 조회
	public List<ScheduleDTO> selectWeeklyScheduleListAndScheduleTypeByHeroidx(int heroIdx); // 특정 캐릭터가 가진 모든 주간 스케줄을 ScheduleType 테이블과 JOIN한 형태로 조회
}
