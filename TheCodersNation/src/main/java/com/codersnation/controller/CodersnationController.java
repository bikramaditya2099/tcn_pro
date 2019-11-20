package com.codersnation.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codersnation.bean.User;
import com.codersnation.controller.exception.CodersNationException;
import com.codersnation.service.UserService;
import com.codersnation.util.FailResponse;
import com.codersnation.util.JwtTokenUtil;

@RestController
@CrossOrigin
public class CodersnationController {

	@Autowired
	UserService userService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Object register(@RequestBody User user) {
	try {
		Object ob=userService.registerUser(user);
		return ob;
	} catch (CodersNationException e) {
		return new FailResponse(e);
	}
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public Object hello() {	
		String s="hello";
		return s;
	}
	
	@RequestMapping(value = "/getUserDetails", method = RequestMethod.GET)
	public Object getUserDetails(HttpServletRequest request, @RequestHeader("token") String token) {	
		final String requestTokenHeader = token;
		String jwtToken = requestTokenHeader.substring(7);
		String userName=jwtTokenUtil.getUsernameFromToken(jwtToken);
		return userService.getUserByUserEmail(userName);
	}
	
	@RequestMapping(value = "/validateOTP/{email}/{otp}", method = RequestMethod.GET)
	public Object validateOTP(HttpServletRequest request,@PathVariable("email") String email,@PathVariable("otp") String otp) {	
		try {
			Object ob= userService.otpValidate(email,otp);
			return ob;
		} catch (CodersNationException e) {
			return new FailResponse(e);
		}
	}
	
	@RequestMapping(value = "/resendOtp/{email}", method = RequestMethod.GET)
	public Object resendOtp(HttpServletRequest request,@PathVariable("email") String email) {	
		try {
			Object ob= userService.resendOtp(email);
			return ob;
		} catch (CodersNationException e) {
			return new FailResponse(e);
		}
	}
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public Object logout(HttpServletRequest request) {	
		final String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = requestTokenHeader.substring(7);
		
		return "Logout Successfull";
	}
}
