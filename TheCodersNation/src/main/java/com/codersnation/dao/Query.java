package com.codersnation.dao;

public interface Query {
	String GET_MAX_USER_ID = "select max(id) as max from user";
	String GET_USER_BY_EMAIL = "select * from user where email=?";
	String INSERT_USER = "insert into user(id,fname,mname,lname,email,password,phonenumber,profile_pic,cv_resume,email_otp,email_otp_expiry_time) values(?,?,?,?,?,?,?,?,?,?,?)";
	String UPDATE_OTP="update user set email_otp_validated=1 where email=?";
	String RESEND_OTP="update user set email_otp=? , email_otp_expiry_time=? where email=?";
	String VALIDATE_ADMIN_LOGIN="select count(*) as count from admin_user where email=? and password=?";
	String UPDATE_ADMIN_TOKEN="update admin_user set admin_token=? where email=?";
	String GET_ADMIN_USER="select ad.*,rd.name role from admin_user ad inner join role rd on rd.id=ad.role_id where admin_token=?";
	String GET_USER_PROFILE="select emailid,degree,passoutyear,postalcode,collegename,aboutme,address from profile_tbl where emailid=?";
	String INSERT_USER_PROFILE="insert into profile_tbl(emailid,degree,passoutyear,postalcode,collegename,aboutme,address) values(?,?,?,?,?,?,?)";
	String UPDATE_USER_PROFILE="update profile_tbl set emailid=?,degree=?,passoutyear=?,postalcode=?,collegename=?,aboutme=?,address=? where emailid=?";	
	String INSERT_EVENT="insert into event_reg(type,name,email,phone,organisation,designation,college,stream,percentage) values(?,?,?,?,?,?,?,?,?)";
	String GET_ALL_EVENT_USERS="select * from event_reg";
}
