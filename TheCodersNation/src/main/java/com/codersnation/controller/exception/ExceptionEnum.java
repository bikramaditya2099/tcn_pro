package com.codersnation.controller.exception;

public enum ExceptionEnum {

	USER_REGISTER_SUCCESS(2000,"USER REGISTERED SUCCESSFULLY","SUCCESS"),
	LOGIN_SUCCESS(2001,"LOGIN SUCCESS","SUCCESS"),
	OTP_VALIDATED(2002,"OTP VALIDATED","SUCCESS"),
	OTP_GENERATED(2003,"OTP GENERATED","SUCCESS"),
	
	DAO_ERROR(8000,"SOMETHING WENT WRONG","FAIL"),
	USER_REGISTER_FAIL(9000,"USER REGISTRATION FAILED","FAIL"),
	USER_ALREADY_EXIST(9001,"USER ALREADY EXIST","FAIL"),
	USER_NOT_EXIST(9002,"USER NOT EXIST","FAIL"),
	INVALID_CREDENTIALS(9003,"INVALID CREDENTIALS","FAIL"),
	OTP_EXPIRED(9004,"OTP EXPIRED","FAIL"),
	OTP_INVALID(9005,"OTP INVALID","FAIL"),
	
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
