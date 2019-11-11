package com.codersnation.controller.exception;

public class CodersNationException extends Exception{

	private static final long serialVersionUID = 1410989536406617033L;
	private int code;
	private String message;
	private String status;
	private Object data;
	
	
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

	public CodersNationException(ExceptionEnum e, Object data) {
		this.code = e.getCode();
		this.message = e.getMessage();
		this.status = e.getStatus();
		this.data = data;
	}
	
	public CodersNationException(ExceptionEnum e) {
		this.code = e.getCode();
		this.message = e.getMessage();
		this.status = e.getStatus();
	}

}
