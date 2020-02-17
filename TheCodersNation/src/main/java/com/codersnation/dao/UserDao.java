package com.codersnation.dao;

import com.codersnation.bean.EventRegistrationBean;
import com.codersnation.bean.User;
import com.codersnation.bean.UserProfile;
import com.codersnation.bean.UserWithUserProfile;
import com.codersnation.controller.exception.CodersNationException;

public interface UserDao {
	User getUserByEmail(String email);
	 User getLoginCredentialsByEmail(String email);
	Object registerUser(User user) throws CodersNationException;
	
	Object authenticate(String userName,String password) throws CodersNationException;
	User validateOTP(String email)throws CodersNationException;
	Object updateOTP(String email)throws CodersNationException;
	Object resendOTP(String email,String otp,String expiryTime) throws CodersNationException;
	UserProfile getUserProfileByEmail(String email)throws CodersNationException;
	Object updateUserProfile(UserWithUserProfile userWithUserProfile) throws CodersNationException;
	Object registerForEvent(EventRegistrationBean bean) throws CodersNationException;
}
