package com.codersnation.dao;

public interface Query {
	String GET_MAX_USER_ID = "select max(id) as max from user";
	String GET_USER_BY_EMAIL = "select * from user where email=?";
	String INSERT_USER = "insert into user(id,fname,mname,lname,email,password,phonenumber,profile_pic,cv_resume,email_otp,email_otp_expiry_time) values(?,?,?,?,?,?,?,?,?,?,?)";
	String UPDATE_OTP="update user set email_otp_validated=1 where email=?";
	String RESEND_OTP="update user set email_otp=? , email_otp_expiry_time=? where email=?";
}
