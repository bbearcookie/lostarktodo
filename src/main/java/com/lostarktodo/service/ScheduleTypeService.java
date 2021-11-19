package com.lostarktodo.service;

import java.util.List;

import com.lostarktodo.domain.ScheduleTypeDTO;

// 스케줄 타입에 관한 비즈니스 로직을 담은 클래스
public interface ScheduleTypeService {
	public List<ScheduleTypeDTO> selectScheduleTypeList(); // DB에 있는 모든 스케줄 타입을 반환함.
}
