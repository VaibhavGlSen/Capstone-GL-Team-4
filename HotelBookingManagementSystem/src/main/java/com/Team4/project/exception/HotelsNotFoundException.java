package com.Team4.project.exception;

public class HotelsNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public HotelsNotFoundException(String message) {
		super(message);
		this.setMessage(message);
	}
	
	public HotelsNotFoundException() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
