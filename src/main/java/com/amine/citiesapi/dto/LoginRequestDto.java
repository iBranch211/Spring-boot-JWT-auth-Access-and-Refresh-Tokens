package com.amine.citiesapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequestDto {
	
	@NotNull
	@NotBlank(message = "Username name can't be blank")
	private String username;
	@NotNull
	@NotBlank(message = "Password name can't be blank")
	private String password;
	public LoginRequestDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public LoginRequestDto() {}


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

	@Override
	public String toString() {
		return "RegisterRequest [username=" + username
				+ ", password=" + password + "]";
	}
	

}
