package com.lostarktodo.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lostarktodo.context.UserContext;
import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.service.AccountService;

public class AccountAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String)authentication.getCredentials();
        
    	UserContext userContext = (UserContext)accountService.loadUserByUsername(username);
    	UserDTO user = userContext.getUser();
    	
    	// 비밀번호가 틀리면
    	if (!passwordEncoder.matches(password, user.getPassword())) {
    		throw new BadCredentialsException("비밀번호가 틀립니다.");
    	}
    	
    	// 타임리프 템플릿엔진을 적용한 html 파일에서 태그 속성으로 sec:authentication="name" 를 적으면 여기 토큰에서 보낸 userContext.getUser() 값이 반환된다.
        UsernamePasswordAuthenticationToken authenticationToken = 
        		new UsernamePasswordAuthenticationToken(userContext.getUser(), null, userContext.getAuthorities());

        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
    	return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
