package com.codersnation.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codersnation.bean.User;

public class LoginRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=null;
		if(rs!=null) {
			user=new User();
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			
		}
		return user;
	}

}
