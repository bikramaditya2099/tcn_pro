package com.codersnation.dao;

import com.codersnation.bean.AdminLoginBean;
import com.codersnation.bean.AdminUser;
import com.codersnation.controller.exception.CodersNationException;

public interface AdminDao {

	Object validateAdmin(AdminLoginBean adminLoginBean) throws CodersNationException;
	AdminUser getAdminUserInfo(String token) throws CodersNationException;
}
