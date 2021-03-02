package com.boot.jwt.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7763401882079276548L;
	private String username;
	private String password;

	/**
	 * Need the Default constructor for JSON Parser, had setter construtor also
	 * sothat need to add the default construtor
	 */
	public JwtRequest() {
	}

	public JwtRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
