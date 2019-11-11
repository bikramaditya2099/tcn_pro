package com.codersnation.controller.exception;

public enum ExceptionEnum {

	USER_REGISTER_SUCCESS(2000,"USER REGISTERED SUCCESSFULLY","SUCCESS"),
	LOGIN_SUCCESS(2001,"LOGIN SUCCESS","SUCCESS"),
	
	
	USER_REGISTER_FAIL(9000,"USER REGISTRATION FAILED","FAIL"),
	USER_ALREADY_EXIST(9001,"USER ALREADY EXIST","FAIL"),
	USER_NOT_EXIST(9002,"USER NOT EXIST","FAIL"),
	INVALID_CREDENTIALS(9003,"INVALID CREDENTIALS","FAIL"),
	;
	
	private int code;
	private String message;
	private String status;
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public String getStatus() {
		return status;
	}
	
	private ExceptionEnum(int code, String message, String status) {
		this.code = code;
		this.message = message;
		this.status = status;
	}
	
	
	
}
