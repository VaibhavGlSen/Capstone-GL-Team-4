package com.Team4.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Team4.project.entity.BookingDetails;


@Service
public interface BookingDetailsService{
	
	
public BookingDetails addBookingDetails(BookingDetails bookingDetails);
	
	public ResponseEntity<BookingDetails> updateBookingDetails(int booking_id,BookingDetails bookingDetails);
	
	public void removeBookingDetails(int Id);
	
	public List<BookingDetails> showAllBookingDetails(BookingDetails bookingDetails);
	
	public BookingDetails showBookingDetailsById(int booking_id);
	
	
	

}
