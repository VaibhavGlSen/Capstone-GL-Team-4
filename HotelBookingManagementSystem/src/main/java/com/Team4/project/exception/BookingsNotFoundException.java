package com.Team4.project.exception;


public class  BookingsNotFoundException
extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	private String message;

	public BookingsNotFoundException(String message) {
		super(message);
		this.setMessage(message);
	}
	
	public BookingsNotFoundException() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}