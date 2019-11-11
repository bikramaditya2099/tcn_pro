package com.codersnation.dao;

import com.codersnation.bean.User;
import com.codersnation.controller.exception.CodersNationException;

public interface UserDao {
	User getUserByEmail(String email);
	 User getLoginCredentialsByEmail(String email);
	Object registerUser(User user) throws CodersNationException;
	
	Object authenticate(String userName,String password) throws CodersNationException;
}
