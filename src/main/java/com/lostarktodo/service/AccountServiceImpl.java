package com.lostarktodo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lostarktodo.context.UserContext;
import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.mapper.UserMapper;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean registerUser(UserDTO params) {
		System.out.println("서비스의 registerUser 호출!!");
		
		// 이미 존재하는 id 일경우
		if (userMapper.checkWhetherExistID(params.getUserid()) > 0) {
			return false;
		}

		params.setPassword(passwordEncoder.encode(params.getPassword()));
		params.setRole("ROLE_USER");
		userMapper.insertUser(params);
		return true;
	}
	
	@Override
	public boolean loginUser(UserDTO params) {
		System.out.println("서비스의 loginUser 호출!!");
		
		return true;
	}
	
	@Override
	public UserContext loadUserByUsername(String userid) throws UsernameNotFoundException {
		UserDTO user = userMapper.findByUserid(userid);

        if (user == null){
            throw new UsernameNotFoundException("UsernameNotFoundException");
        }
        
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole()));

        UserContext accountContext = new UserContext(user, roles);

        return accountContext;
	}
}
