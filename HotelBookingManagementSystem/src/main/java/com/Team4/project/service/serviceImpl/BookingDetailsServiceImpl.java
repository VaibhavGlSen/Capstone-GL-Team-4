package com.Team4.project.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Team4.project.entity.BookingDetails;
import com.Team4.project.repository.IBookingDetailsRepository;
import com.Team4.project.service.services.BookingDetailsService;

@Component
public class BookingDetailsServiceImpl implements BookingDetailsService{
	@Autowired
	IBookingDetailsRepository repo;

	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingdetails) {
		repo.save(bookingdetails);
		return bookingdetails;
	}

	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingdetails) {
		repo.save(bookingdetails);
		return bookingdetails;
	}

	@Override
	public String removeBookingDetails(int id) {
		repo.deleteById(id);
		return "Record has been deleted!";
	}

	@Override
	public List<BookingDetails> showAllBookingDetails() {
		return repo.findAll();
	}

	@Override
	public BookingDetails showBookingDetails(int id) {
		return repo.findById(id).get();
	}

}
