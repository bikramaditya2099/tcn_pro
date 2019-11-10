package com.codersnation.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
	UserDetails getUserByUserName(String userName);
}
