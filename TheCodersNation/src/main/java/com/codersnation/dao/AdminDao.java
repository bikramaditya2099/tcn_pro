package com.codersnation.dao;

import java.util.List;

import com.codersnation.bean.AdminLoginBean;
import com.codersnation.bean.AdminUser;
import com.codersnation.bean.EventRegistrationBean;
import com.codersnation.controller.exception.CodersNationException;

public interface AdminDao {

	Object validateAdmin(AdminLoginBean adminLoginBean) throws CodersNationException;
	AdminUser getAdminUserInfo(String token) throws CodersNationException;
	List<EventRegistrationBean> getregisteredusers(String token) throws CodersNationException;
}
