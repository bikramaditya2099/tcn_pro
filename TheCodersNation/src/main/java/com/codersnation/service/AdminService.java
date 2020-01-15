package com.codersnation.service;

import com.codersnation.bean.AdminLoginBean;
import com.codersnation.bean.AdminUser;
import com.codersnation.controller.exception.CodersNationException;

public interface AdminService {
Object validateAdminLogin(AdminLoginBean adminLoginBean) throws CodersNationException;
AdminUser getAdminUser(String token) throws CodersNationException;
}
