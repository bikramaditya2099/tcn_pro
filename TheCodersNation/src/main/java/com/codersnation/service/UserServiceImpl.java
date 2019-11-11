package com.codersnation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.codersnation.controller.exception.CodersNationException;
import com.codersnation.controller.exception.ExceptionEnum;
import com.codersnation.dao.UserDao;


@Repository
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	UserDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.codersnation.bean.User user=dao.getLoginCredentialsByEmail(username);
		if(user==null)
		throw new UsernameNotFoundException("User not found");
		List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();	
		list.add(new SimpleGrantedAuthority("ROLE_USER"));
	    UserDetails userDetails =new User(user.getEmail(),  user.getPassword(),  list);
		return userDetails;
	}

	@Override
	public Object registerUser(com.codersnation.bean.User user) throws CodersNationException {
		return dao.registerUser(user);
		
	}

	@Override
	public Object authenticate(String userName, String password) throws CodersNationException {
		return dao.authenticate(userName, password);
	}

	@Override
	public Object getUserByUserEmail(String userName) {
		return dao.getUserByEmail(userName);
	}

}
