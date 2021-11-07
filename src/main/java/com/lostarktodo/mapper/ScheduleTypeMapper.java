package com.lostarktodo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lostarktodo.domain.ScheduleTypeDTO;

@Mapper
public interface ScheduleTypeMapper {
	public List<ScheduleTypeDTO> selectScheduleTypeList();
}
