package com.lostarktodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lostarktodo.domain.UserDTO;

@Service
public class TestService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDTO save(UserDTO user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		
		return new UserDTO();
	}
}
