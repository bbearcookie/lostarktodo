package com.lostarktodo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lostarktodo.domain.UserDTO;

// User 테이블에 대한 모든 쿼리문을 모은 인터페이스
@Mapper
public interface UserMapper {
	public int insertUser(UserDTO params); // 유저 추가
	public int checkWhetherExistUsername(String userid); // 해당 아이디가 이미 존재하는지 여부 반환
	public UserDTO findByUsername(String userid); // 해당 아이디의 유저 정보 조회
}
