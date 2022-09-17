package com.Team4.project.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserNotFoundException() {
		
	}

	public UserNotFoundException(String message) {
		super(message);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
