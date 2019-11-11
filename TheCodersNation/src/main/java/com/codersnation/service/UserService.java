package com.codersnation.service;

import com.codersnation.bean.User;
import com.codersnation.controller.exception.CodersNationException;

public interface UserService {
	Object registerUser(User user)throws CodersNationException;
	Object authenticate(String userName,String password) throws CodersNationException;
	Object getUserByUserEmail(String userName);
}
