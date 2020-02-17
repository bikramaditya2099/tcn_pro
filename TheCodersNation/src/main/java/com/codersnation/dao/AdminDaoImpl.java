package com.codersnation.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.codersnation.bean.AdminLoginBean;
import com.codersnation.bean.AdminUser;
import com.codersnation.bean.EventRegistrationBean;
import com.codersnation.bean.User;
import com.codersnation.controller.exception.CodersNationException;
import com.codersnation.controller.exception.ExceptionEnum;
import com.codersnation.rowmapper.AdminUserRowMapper;
import com.codersnation.rowmapper.EventUserRowMapper;
import com.codersnation.rowmapper.UserRowMapper;
import com.codersnation.util.AdminTokenUtil;
import com.codersnation.util.FailResponse;
import com.codersnation.util.SuccessResponse;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public Object validateAdmin(AdminLoginBean adminLoginBean) throws CodersNationException{
			String sql=Query.VALIDATE_ADMIN_LOGIN;
			Object args[]= {adminLoginBean.getUsername(),adminLoginBean.getPassword()};
			Map<String, Object> map=null;
			try {
				 map= jdbcTemplate.queryForMap(sql,args);
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(map!=null && map.containsKey("count")) {
				if((Long)map.get("count")==1) {
				String token=AdminTokenUtil.generateToken();
				sql=Query.UPDATE_ADMIN_TOKEN;
				jdbcTemplate.update(sql, token,adminLoginBean.getUsername());
				return new SuccessResponse(ExceptionEnum.LOGIN_SUCCESS,token);
				}
				else
					throw new CodersNationException(ExceptionEnum.INVALID_CREDENTIALS);
			}
			else
				throw new CodersNationException(ExceptionEnum.INVALID_CREDENTIALS);
	}
	@Override
	public AdminUser getAdminUserInfo(String token) throws CodersNationException {
		String sql=Query.GET_ADMIN_USER;
		Object args[]= {token};
		AdminUser user=null;
		try {
		 user=	jdbcTemplate.queryForObject(sql, args, new AdminUserRowMapper());
		}catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new CodersNationException(ExceptionEnum.USER_NOT_EXIST);
		}
		return user;
	}
	@Override
	public List<EventRegistrationBean> getregisteredusers(String token) throws CodersNationException {
		String sql=Query.GET_ALL_EVENT_USERS;
		getAdminUserInfo(token);
		
		List<EventRegistrationBean> user=null;
		try {
		 user=	jdbcTemplate.query(sql, new EventUserRowMapper());
		}catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new CodersNationException(ExceptionEnum.USER_NOT_EXIST);
		}
		return user;
	}
	
	

}
