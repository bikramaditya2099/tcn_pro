package com.codersnation.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codersnation.bean.AdminUser;
import com.codersnation.bean.EventRegistrationBean;

public class EventUserRowMapper  implements RowMapper<EventRegistrationBean>{

	@Override
	public EventRegistrationBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		EventRegistrationBean user=null;
		if(rs!=null) {
			user=new EventRegistrationBean();
			user.setEmail(rs.getString("email"));
			user.setCollege(rs.getString("college"));
			user.setDesignation(rs.getString("designation"));
			user.setName(rs.getString("name"));
			user.setOrganisation(rs.getString("organisation"));
			user.setPhone(rs.getString("phone"));
			user.setPercentage(rs.getDouble("percentage"));
			user.setType(rs.getString("type"));
			user.setStream(rs.getString("stream"));
			user.setId(rs.getInt("id"));
			
		}
		return user;
	}

}
