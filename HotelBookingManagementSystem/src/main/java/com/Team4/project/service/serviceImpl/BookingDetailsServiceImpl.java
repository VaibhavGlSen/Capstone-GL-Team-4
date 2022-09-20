package com.Team4.project.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Team4.project.entity.BookingDetails;
import com.Team4.project.exception.BookingsNotFoundException;
import com.Team4.project.repository.IBookingDetailsRepository;
import com.Team4.project.service.services.BookingDetailsService;

@Component
public class BookingDetailsServiceImpl implements BookingDetailsService{
	@Autowired
	IBookingDetailsRepository repo;

	
	//To add booking details
	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingdetails) {
		repo.save(bookingdetails);
		return bookingdetails;
	}
	
	//Update booking details

	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingdetails) {
		repo.save(bookingdetails);
		return bookingdetails;
	}

	//delete booking details by Id
	@Override
	public String removeBookingDetails(int id) {
		repo.deleteById(id);
		return "Record has been deleted!";
	}

	
	//fetch all booking details
	@Override
	public List<BookingDetails> showAllBookingDetails() {
		return repo.findAll();
	}

	
	//show booking details by Id
	@Override
	public Optional<BookingDetails> showBookingDetails(int id) {
		return this.repo.findById(id);
		
		
	}

}
