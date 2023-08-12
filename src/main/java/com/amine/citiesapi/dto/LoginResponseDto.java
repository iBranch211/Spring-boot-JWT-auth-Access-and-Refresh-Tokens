package com.amine.citiesapi.dto;


public class LoginResponseDto {
	
	private String message;
	private String accessToken;
	private String refreshToken;
	
	public LoginResponseDto() {}
	
	public LoginResponseDto(String message, String accessToken, String refreshToken) {
		this.message = message;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Override
	public String toString() {
		return "LoginResponseDto [message=" + message + ", accessToken=" + accessToken + ", refreshToken="
				+ refreshToken + "]";
	}



	
}
