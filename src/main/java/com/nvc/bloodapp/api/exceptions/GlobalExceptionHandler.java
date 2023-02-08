package com.nvc.bloodapp.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nvc.bloodapp.api.responses.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiResponse> notFound (NotFoundException ex){
		return new ResponseEntity<>(new ApiResponse(ex.getMessage(),false),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyFieldException.class)
	public ResponseEntity<ApiResponse> emptyField(EmptyFieldException ex){
		return new ResponseEntity<>(new ApiResponse(ex.getMessage(),false),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ApiResponse> customEx(CustomException ex){
		return new ResponseEntity<>(new ApiResponse(ex.getMessage(),false),HttpStatus.BAD_REQUEST);
	}
	
	
}
