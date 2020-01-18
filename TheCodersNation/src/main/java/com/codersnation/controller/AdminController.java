package com.codersnation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codersnation.bean.AdminLoginBean;
import com.codersnation.bean.SMSBean;
import com.codersnation.controller.exception.CodersNationException;
import com.codersnation.service.AdminService;
import com.codersnation.service.UserService;
import com.codersnation.util.FailResponse;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	UserService userService;
	@Autowired
	AdminService adminService;
	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public Object login(@RequestBody AdminLoginBean adminLoginBean ) {
		try {
			return adminService.validateAdminLogin(adminLoginBean);
		}
		catch(CodersNationException e) {
			return new FailResponse(e);
		}
		
	}
	@RequestMapping(value = "/getadminuser", method = RequestMethod.GET)
	public Object getAdminUserInfo(@RequestHeader("token") String token) {
		try {
			return adminService.getAdminUser(token);
		}
		catch(CodersNationException e) {
			return new FailResponse(e);
		}
	}
	
	@RequestMapping(value = "/sendsms", method = RequestMethod.POST)
	public Object sendSMS(@RequestHeader("token") String token,@RequestBody SMSBean bean) {
		try {
			
			return adminService.sendsms(bean,token);
		}
		catch(CodersNationException e) {
			return new FailResponse(e);
		}
	}
}
