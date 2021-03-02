package com.boot.jwt.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5943322421992868335L;
	/**
	 * 
	 * final variable, no setter method, only option to set the value into the class
	 * conctrutor
	 * 
	 */
	private final String jwtToken;

	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

}
