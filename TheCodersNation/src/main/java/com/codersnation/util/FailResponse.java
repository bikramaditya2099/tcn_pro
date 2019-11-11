package com.codersnation.util;

import com.codersnation.controller.exception.CodersNationException;

public class FailResponse {
private int code;
private String message;
private String status;
public FailResponse(CodersNationException e) {
	this.code = e.getCode();
	this.message = e.getMessage();
	this.status = e.getStatus();
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


}
