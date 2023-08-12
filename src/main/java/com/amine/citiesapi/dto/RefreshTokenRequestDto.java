package com.amine.citiesapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RefreshTokenRequestDto {
	
	@NotNull
	@NotBlank(message = "Refresh token can't be blank")
	private String refreshToken;
	
	public RefreshTokenRequestDto() {}

	public RefreshTokenRequestDto(String refreshToken) {
		super();
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Override
	public String toString() {
		return "RefreshTokenRequestDto [refreshToken=" + refreshToken + "]";
	}
	
	

}
