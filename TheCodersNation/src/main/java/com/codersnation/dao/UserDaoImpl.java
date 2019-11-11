package com.codersnation.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.codersnation.bean.User;
import com.codersnation.controller.exception.CodersNationException;
import com.codersnation.controller.exception.ExceptionEnum;
import com.codersnation.rowmapper.LoginRowMapper;
import com.codersnation.rowmapper.UserRowMapper;
import com.codersnation.util.SuccessResponse;
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Object registerUser(User user) throws CodersNationException {
		String sql=Query.INSERT_USER;
	User existingUser =	getUserByEmail(user.getEmail());
		if(existingUser==null) {
			long maxId=getMaxUserId()+1;
			user.setProfilePic("");
			user.setResume("");
			if(user.getMname()==null)
				user.setMname("");
			Object args[]= {maxId,user.getFname(),user.getMname(),user.getLname(),user.getEmail(),user.getPassword(),user.getPhoneNumber(),user.getProfilePic(),user.getResume()};
			
			int inserted=jdbcTemplate.update(sql, args);
			return new SuccessResponse(ExceptionEnum.USER_REGISTER_SUCCESS, inserted);
		}
		else {
			throw new CodersNationException(ExceptionEnum.USER_ALREADY_EXIST);
		}
	}

	@Override
	public User getUserByEmail(String email) {
		String sql=Query.GET_USER_BY_EMAIL;
		Object args[]= {email};
		User user=null;
		try {
			user = jdbcTemplate.queryForObject(sql,args ,new UserRowMapper());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public User getLoginCredentialsByEmail(String email) {
		String sql=Query.GET_USER_BY_EMAIL;
		Object args[]= {email};
		User user=null;
		try {
			user = jdbcTemplate.queryForObject(sql,args ,new LoginRowMapper());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	private long getMaxUserId() {
		String sql=Query.GET_MAX_USER_ID;
		Map<String,Object> map=jdbcTemplate.queryForMap(sql);
		return (long) map.get("max");
	}

	@Override
	public Object authenticate(String userName, String password) throws CodersNationException {
		User user=getLoginCredentialsByEmail(userName);
		if(user==null)
			throw new CodersNationException(ExceptionEnum.USER_NOT_EXIST);
		if(!user.getPassword().equals(password))
		throw new CodersNationException(ExceptionEnum.INVALID_CREDENTIALS);
		else
			return new SuccessResponse(ExceptionEnum.LOGIN_SUCCESS, user);
	}

}
