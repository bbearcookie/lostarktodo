package com.lostarktodo.service;

import java.util.List;

import com.lostarktodo.domain.ScheduleDTO;

// 스케줄에 관한 비즈니스 로직을 담은 클래스
public interface ScheduleService {
	public boolean registerSchedule(ScheduleDTO params);  // 스케줄의 정보를 업데이트하거나 새로 생성
	public boolean deleteSchedule(int idx); // 스케줄 제거
	public List<ScheduleDTO> selectDailyScheduleListAndScheduleTypeByHeroidx(int scheduleIdx); // 특정 캐릭터의 모든 일간 스케줄을 스케줄 타입 테이블과 JOIN한 형태로 반환
	public List<ScheduleDTO> selectWeeklyScheduleListAndScheduleTypeByHeroidx(int scheduleIdx); // 특정 캐릭터의 모든 주간 스케줄을 스케줄 타입 테이블과 JOIN한 형태로 반환
	public ScheduleDTO increaseCompleteSchedule(int scheduleIdx); // 특정 스케줄의 완료 횟수를 1 만큼 증가시킴. 최대치 초과하면 0 으로 설정.
	public ScheduleDTO getSchedule(int scheduleIdx); // 해당 스케줄 정보를 반환함
	public void calculateRestingGauge(); // 모든 스케줄의 완료 횟수와 휴식 게이지를 기준에 따라서 계산하여 초기화시킴.
}
