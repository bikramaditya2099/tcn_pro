package com.codersnation.dao;

public interface Query {
	String GET_MAX_USER_ID = "select max(id) as max from user";
	String GET_USER_BY_EMAIL = "select * from user where email=?";
	String INSERT_USER = "insert into user(id,fname,mname,lname,email,password,phonenumber,profile_pic,cv_resume) values(?,?,?,?,?,?,?,?,?)";
}
