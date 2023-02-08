package com.nvc.bloodapp.api.exceptions;

public class EmptyFieldException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EmptyFieldException() {
		super();
	}
	
	public EmptyFieldException(String message) {
		super(message);
	}

}
