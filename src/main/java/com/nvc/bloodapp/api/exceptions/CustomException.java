package com.nvc.bloodapp.api.exceptions;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CustomException() {
	        super();
	    }
	public CustomException(String message) {
        super(message);
    }
}
