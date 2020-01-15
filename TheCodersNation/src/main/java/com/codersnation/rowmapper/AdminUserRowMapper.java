package com.codersnation.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codersnation.bean.AdminUser;

public class AdminUserRowMapper  implements RowMapper<AdminUser> {

	@Override
	public AdminUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminUser user=null;
		if(rs!=null) {
			user=new AdminUser();
			user.setId(rs.getLong("id"));
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
			user.setPhoneNumber(rs.getString("phonenumber"));
			user.setProfilePic(rs.getString("profile_pic"));
			user.setEmail(rs.getString("email"));
			user.setRoleId(rs.getInt("role_id"));
			user.setRole(rs.getString("role"));
			
		}
		return user;
	}
	

}
