package com.codersnation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codersnation.bean.AdminLoginBean;
import com.codersnation.bean.AdminUser;
import com.codersnation.controller.exception.CodersNationException;
import com.codersnation.dao.AdminDao;
@Repository
public class AdminServiceImpl implements AdminService{
@Autowired
AdminDao adminDao;
	@Override
	public Object validateAdminLogin(AdminLoginBean adminLoginBean) throws CodersNationException {
		return adminDao.validateAdmin(adminLoginBean);
	}
	@Override
	public AdminUser getAdminUser(String token) throws CodersNationException {
		return adminDao.getAdminUserInfo(token);
	}

}
