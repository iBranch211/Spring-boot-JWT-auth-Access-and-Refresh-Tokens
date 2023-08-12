package com.amine.citiesapi.exceptions;

import java.time.LocalDateTime;

public class ErrorObject {
	
	private Integer statusCode;
	private String message;
	private LocalDateTime timestamp;
	public ErrorObject(Integer statusCode, String message, LocalDateTime timestamp) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timestamp = timestamp;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ErrorObject [statusCode=" + statusCode + ", message=" + message + ", timestamp=" + timestamp + "]";
	}
	
	

}
