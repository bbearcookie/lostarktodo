package com.lostarktodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.mapper.UserMapper;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean registerUser(UserDTO params) {
		System.out.println("서비스의 registerUser 호출!!");
		
		// 이미 존재하는 id 일경우
		if (userMapper.checkWhetherExistID(params.getUserid()) > 0) {
			return false;
		}
		
		userMapper.insertUser(params);
		return true;
	}
}
