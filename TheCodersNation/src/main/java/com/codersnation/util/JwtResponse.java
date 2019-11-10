package com.codersnation.util;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 7679531155441402529L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}