package com.lostarktodo.context;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.lostarktodo.domain.UserDTO;

public class UserContext extends User {

    private final UserDTO user;

    public UserContext(UserDTO user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

    public UserDTO getUser() {
    	System.out.println("getUser(): " + user);
        return user;
    }
}