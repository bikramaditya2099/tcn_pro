package com.codersnation.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codersnation.bean.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=null;
		if(rs!=null) {
			user=new User();
			user.setId(rs.getLong("id"));
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
			user.setMname(rs.getString("mname"));
			user.setPhoneNumber(rs.getString("phonenumber"));
			user.setProfilePic(rs.getString("profile_pic"));
			user.setEmail(rs.getString("email"));
			user.setResume(rs.getString("cv_resume"));
			
		}
		return user;
	}

}
