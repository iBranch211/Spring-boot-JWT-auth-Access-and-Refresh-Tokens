package com.amine.citiesapi.dto;


public class RegisterResponseDto {
	
	private String message;
	
	public RegisterResponseDto() {}
	
	public RegisterResponseDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "RegisterResponseDto [message=" + message + "]";
	}
	

}
