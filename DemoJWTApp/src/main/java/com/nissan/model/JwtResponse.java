package com.nissan.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = 1461975356878879456L;
	
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}

}
