package com.qsp.hospital_app.exception;

public class EmailNotFoundException extends RuntimeException{
	
	String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public EmailNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
