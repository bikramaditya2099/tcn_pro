package com.codersnation.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.codersnation.bean.AdminLoginBean;
import com.codersnation.bean.AdminUser;
import com.codersnation.bean.SMSBean;
import com.codersnation.controller.exception.CodersNationException;
import com.codersnation.controller.exception.ExceptionEnum;
import com.codersnation.dao.AdminDao;
@Repository
public class AdminServiceImpl implements AdminService{
@Autowired
AdminDao adminDao;
@Value("${smsapi.token}")
String smsToken;
	@Override
	public Object validateAdminLogin(AdminLoginBean adminLoginBean) throws CodersNationException {
		return adminDao.validateAdmin(adminLoginBean);
	}
	@Override
	public AdminUser getAdminUser(String token) throws CodersNationException {
		return adminDao.getAdminUserInfo(token);
	}
	@Override
	public Object sendsms(SMSBean smsBean,String token) throws CodersNationException {
		adminDao.getAdminUserInfo(token);
		Map<String,Object> response=null;
		try {
		RestTemplate restTemplate=new RestTemplate();
		String numList="";
		for(String num:smsBean.getNumbers()) {
			numList=numList+num.trim()+",";
		}
		numList=numList.substring(0, (numList.length())-1);
		
		String url="https://www.smsgatewayhub.com/api/mt/SendSMS?APIKey="+smsToken+"&senderid="+smsBean.getSenderId()+"&channel=2&DCS=0&flashsms=0&number="+numList+"&text="+smsBean.getText()+"&route=1";
		
		 response=restTemplate.getForObject(url, Map.class);
		}
		catch(Exception e) {
			throw new CodersNationException(ExceptionEnum.DAO_ERROR);
		}
		return response;
	} 

}
