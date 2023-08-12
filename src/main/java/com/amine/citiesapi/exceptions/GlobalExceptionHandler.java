package com.amine.citiesapi.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorObject> handleAllExceptions(Exception ex, WebRequest request){
		ErrorObject errorObject =  new ErrorObject(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorObject> handleBadRequestExceptions(MethodArgumentNotValidException ex, WebRequest request){
		ErrorObject errorObject =  new ErrorObject(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<ErrorObject> handleCityNotFoundException(CityNotFoundException ex, WebRequest request){
		ErrorObject errorObject = new ErrorObject(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
	}
	

}
