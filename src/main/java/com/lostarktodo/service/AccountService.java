package com.lostarktodo.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.security.UserContext;

// 사용자 계정에 관한 비즈니스 로직을 담은 클래스
public interface AccountService {
	public boolean checkWhetherExistUsername(String username); // 해당 아이디를 가진 계정이 존재하는지 true or false 반환
	public boolean checkWhetherSamePassword(UserDTO params); // 입력받은 UserDTO 객체와 실제 DB에 저장된 비밀번호가 일치한지 반환
	public boolean registerUser(UserDTO params); // 새로운 유저 등록. 성공시 true 실패시 false
	public UserContext loadUserByUsername(String username) throws UsernameNotFoundException; // 스프링 시큐리티 인증 기능에서 사용되는 메소드로, 해당 아이디를 가지고 DB에서 조회하여 role 등을 담음.
}
