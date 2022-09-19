package com.Team4.project.exception;

public class RoomDetailsNotFoundException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	private String message;

	public RoomDetailsNotFoundException(String message) {
		super(message);
		this.setMessage(message);
	}
	
	public RoomDetailsNotFoundException() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
