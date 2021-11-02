package com.lostarktodo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lostarktodo.domain.UserDTO;

@Mapper
public interface UserMapper {
	public int insertUser(UserDTO params);
	public UserDTO selectUserDetail(int idx);
	public List<UserDTO> selectUserList(UserDTO params);
}
