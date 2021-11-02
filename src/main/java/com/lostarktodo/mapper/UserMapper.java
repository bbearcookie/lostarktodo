package com.lostarktodo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lostarktodo.domain.UserDTO;

@Mapper
public interface UserMapper {
	public int insertUser(UserDTO params);
	public int checkWhetherExistID(String userid);
}
