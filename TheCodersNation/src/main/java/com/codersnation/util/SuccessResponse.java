package com.codersnation.util;

import com.codersnation.controller.exception.ExceptionEnum;

public class SuccessResponse {

	private int code;
	private String message;
	private String status;
	private Object data;
	public SuccessResponse(ExceptionEnum e, Object data) {
		this.code = e.getCode();
		this.message = e.getMessage();
		this.status = e.getStatus();
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public String getStatus() {
		return status;
	}
	public Object getData() {
		return data;
	}
	
	
	
}
