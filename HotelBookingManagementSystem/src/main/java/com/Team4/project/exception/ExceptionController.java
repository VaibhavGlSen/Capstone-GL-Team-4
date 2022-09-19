package com.Team4.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
   public class ExceptionController {
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<Object> exception(ResourceNotFoundException exception){
		return new ResponseEntity<>("Resource not found with the entered Hotel Id",HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(value = HotelsNotFoundException.class)
	public ResponseEntity<Object> exception(HotelsNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = BookingsNotFoundException.class)
	public ResponseEntity<Object> exception(BookingsNotFoundException exception){
	    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value = RoomDetailsNotFoundException.class)
	public ResponseEntity<Object> exception(RoomDetailsNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	 
	 
	
	
}