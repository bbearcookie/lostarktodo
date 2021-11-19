package com.lostarktodo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lostarktodo.domain.ScheduleTypeDTO;

// ScheduleType 테이블에 관한 쿼리문을 모은 인터페이스
@Mapper
public interface ScheduleTypeMapper {
	public List<ScheduleTypeDTO> selectScheduleTypeList(); // DB에 저장된 모든 캐릭터 타입 조회
}
