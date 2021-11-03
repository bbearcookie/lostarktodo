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
	public boolean checkWhetherExistUsername(String username) {
		if (userMapper.checkWhetherExistUsername(username) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean checkWhetherSamePassword(UserDTO params) {
		UserDTO originData = userMapper.findByUsername(params.getUsername());
		
		if (passwordEncoder.matches(params.getPassword(), originData.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean registerUser(UserDTO params) {
		// 이미 존재하는 id 일경우
		if (checkWhetherExistUsername(params.getUsername())) {
			return false;
		}

		params.setPassword(passwordEncoder.encode(params.getPassword()));
		params.setRole("ROLE_USER");
		userMapper.insertUser(params);
		return true;
	}
	
	@Override
	public UserContext loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO user = userMapper.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("UsernameNotFoundException");
        }
        
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole()));

        UserContext accountContext = new UserContext(user, roles);

        return accountContext;
	}
}
