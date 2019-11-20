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
import com.codersnation.util.EmailUtil;


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
		String name=user.getFname()+" "+user.getLname();
		String time=String.valueOf(System.currentTimeMillis()+(5*60*1000));
		String otp=EmailUtil.generatePIN();
		user.setEmailOtp(otp);
		user.setEmailExpiry(time);
		Object ob=dao.registerUser(user);
		EmailUtil.sendEmail(user.getEmail(), "Welcome to thecodersnation", EmailUtil.createRegistrationTemplate(name, otp));
		return ob;
		
	}

	@Override
	public Object authenticate(String userName, String password) throws CodersNationException {
		return dao.authenticate(userName, password);
	}

	@Override
	public Object getUserByUserEmail(String userName) {
		return dao.getUserByEmail(userName);
	}

	@Override
	public Object otpValidate(String email,String otp) throws CodersNationException {
		com.codersnation.bean.User ob=dao.validateOTP(email);
		Long otpExpiry=Long.valueOf(ob.getEmailExpiry());
		Long now=System.currentTimeMillis();
		if(!otp.equals(ob.getEmailOtp())) {
			throw new CodersNationException(ExceptionEnum.OTP_INVALID);
		}
		if(now>otpExpiry)
			throw new CodersNationException(ExceptionEnum.OTP_EXPIRED);
		else {
			return dao.updateOTP(email);
		}
		
	}

	@Override
	public Object resendOtp(String email) throws CodersNationException {
		String otp=EmailUtil.generatePIN();
		com.codersnation.bean.User user=(com.codersnation.bean.User) getUserByUserEmail(email);
		String name=user.getFname()+" "+user.getLname();
		Object ob=dao.resendOTP(email, otp, String.valueOf(System.currentTimeMillis()));
		EmailUtil.sendEmail(email, "Welcome to thecodersnation ", EmailUtil.createRegistrationTemplate(name, otp));
		
		return ob;
	}
	
	
	

}
