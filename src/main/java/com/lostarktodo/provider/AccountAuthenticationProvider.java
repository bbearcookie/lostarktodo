package com.lostarktodo.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import com.lostarktodo.context.UserContext;
import com.lostarktodo.service.AccountService;

public class AccountAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private AccountService accountService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	System.out.println("authenticate 메소드 동작");
    	
        String userid = authentication.getName();
        String password = (String) authentication.getCredentials();
        
        System.out.println("id: " + userid);
        System.out.println("password: " + password);
        
        List<GrantedAuthority> roles = new ArrayList<>();
        
    	UserContext userContext = (UserContext)accountService.loadUserByUsername(userid);
        UsernamePasswordAuthenticationToken authenticationToken = 
        		new UsernamePasswordAuthenticationToken(userContext.getUser(), null, userContext.getAuthorities());

        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
    	System.out.println("supports 메소드 동작");
    	
    	return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
