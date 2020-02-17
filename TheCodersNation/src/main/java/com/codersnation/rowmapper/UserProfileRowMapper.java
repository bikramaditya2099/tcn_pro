package com.codersnation.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codersnation.bean.UserProfile;

public class UserProfileRowMapper implements RowMapper<UserProfile>{

	@Override
	public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserProfile userProfile=null;
		
		if(rs!=null) {
			userProfile=new UserProfile();
			userProfile.setAboutMe(rs.getString("aboutme"));
			userProfile.setAddress(rs.getString("address"));
			userProfile.setCollegeName(rs.getString("collegename"));
			userProfile.setEmailId(rs.getString("emailid"));
			userProfile.sethDegree(rs.getString("degree"));
			userProfile.setPassoutYear(rs.getInt("passoutyear"));
			userProfile.setPostalCode(rs.getLong("postalcode"));
			
		}
		
		return userProfile;
	}

}
