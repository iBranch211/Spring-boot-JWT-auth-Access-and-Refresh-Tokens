package com.amine.citiesapi.dto;

public class RefreshTokenResponseDto {
	
	private String message;
	private String accessToken;
	
	public RefreshTokenResponseDto() {}

	public RefreshTokenResponseDto(String message, String accessToken) {
		super();
		this.message = message;
		this.accessToken = accessToken;
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

	@Override
	public String toString() {
		return "RefreshTokenResponseDto [message=" + message + ", accessToken=" + accessToken + "]";
	}
	

}
