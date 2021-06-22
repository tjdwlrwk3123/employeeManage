package com.yang.empl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yang.empl.service.LoginService;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private LoginService lService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfoDetail userinfo=lService.getAuth(username);
		return userinfo;
	}
	
}
