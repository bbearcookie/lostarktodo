package com.lostarktodo.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lostarktodo.context.UserContext;
import com.lostarktodo.domain.UserDTO;

public interface AccountService {
	public boolean registerUser(UserDTO params);
	public boolean loginUser(UserDTO params);
	public UserContext loadUserByUsername(String username) throws UsernameNotFoundException;
}
