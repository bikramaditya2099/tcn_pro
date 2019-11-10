package com.codersnation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


@Repository
public class UserServiceImpl implements UserService, UserDetailsService{

	@Override
	public UserDetails getUserByUserName(String userName) {
		//User user=new User(userName, "password", true, true, true, true, new GrantedAuthority[]{ new GrantedAuthorityImpl("ROLE_USER") });
		
		List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
		list.add(new SimpleGrantedAuthority("ROLE_USER"));
	    UserDetails userDetails =new User(userName,  "password",  list);
		return userDetails;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
		list.add(new SimpleGrantedAuthority("ROLE_USER"));
	    UserDetails userDetails =new User("bikram1",  "password",  list);
		return userDetails;
	}

}
