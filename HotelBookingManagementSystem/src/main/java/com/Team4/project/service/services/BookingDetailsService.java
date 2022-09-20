package com.Team4.project.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Team4.project.entity.BookingDetails;

@Service
public interface BookingDetailsService {
	
	public BookingDetails addBookingDetails(BookingDetails bookingdetails);
	
	public BookingDetails updateBookingDetails(BookingDetails bookingdetails);
	
	public String removeBookingDetails(int id);
	
	public List<BookingDetails> showAllBookingDetails();
	
	public Optional<BookingDetails> showBookingDetails(int id);

}
