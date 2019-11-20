package com.codersnation.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codersnation.bean.User;

public class OTPRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=null;
		if(rs!=null) {
			user=new User();
			user.setId(rs.getLong("id"));
			user.setEmail(rs.getString("email"));
			user.setEmailOtp(rs.getString("email_otp"));
			user.setEmailExpiry(rs.getString("email_otp_expiry_time"));
		}
		return user;
	}
}
