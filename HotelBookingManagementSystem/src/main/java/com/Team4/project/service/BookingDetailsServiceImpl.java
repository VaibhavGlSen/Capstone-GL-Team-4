package com.Team4.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Team4.project.entity.BookingDetails;
import com.Team4.project.entity.Payment;
import com.Team4.project.entity.RoomDetails;
import com.Team4.project.exception.BookingsNotFoundException;
import com.Team4.project.repository.BookingDetailsRepo;
import com.Team4.project.repository.PaymentRepo;
import com.Team4.project.repository.RoomDetailsRepo;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService{
	@Autowired
	BookingDetailsRepo bookingRepo;
	
	@Autowired
	RoomDetailsRepo roomRepo;
	
	
	@Autowired
	PaymentRepo payrepo;

	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingDetails) {
		
		List<RoomDetails>add=new ArrayList<>();
		for(RoomDetails a:bookingDetails.getRoomDetails()) {
			RoomDetails room=roomRepo.findById(a.getRoom_id()).get();
			add.add(room);	
		}
		
		List<Payment>payment=new ArrayList<>();
		for(Payment a:bookingDetails.getPayment()) {
			Payment pay=payrepo.findById(a.getPayment_id()).get();
			payment.add(pay);
		}
		
		bookingDetails.setRoomDetails(add);
		bookingDetails.setPayment(payment);
		this.bookingRepo.save(bookingDetails);
		
		return bookingDetails;
	}

	@Override
	public ResponseEntity<BookingDetails> updateBookingDetails(int booking_id, BookingDetails bookingDetails) {
BookingDetails updateBookings=this.bookingRepo.findById(booking_id).orElseThrow();
		
		updateBookings.setAmount(bookingDetails.getAmount());
		updateBookings.setBooked_from(bookingDetails.getBooked_from());
		updateBookings.setBooked_to(bookingDetails.getBooked_to());
		updateBookings.setNo_of_adults(bookingDetails.getNo_of_adults());
		updateBookings.setNo_of_children(bookingDetails.getNo_of_children());
		updateBookings.setRoomDetails(bookingDetails.getRoomDetails());
		
		 this.bookingRepo.save(updateBookings);
		 return ResponseEntity.ok(bookingDetails);
	}

	@Override
	public void removeBookingDetails(int Id) {
		this.bookingRepo.deleteById(Id);
		
	}

	@Override
	public List<BookingDetails> showAllBookingDetails(BookingDetails bookingDetails) {
	
		return this.bookingRepo.findAll();
	}
	
	
	//------------------------------------------------------------//
	//show bookings by Id

	@Override
	public BookingDetails showBookingDetailsById( int booking_id) {
		Optional<BookingDetails>details=bookingRepo.findById(booking_id);
		if(!details.isPresent())
			throw new BookingsNotFoundException();
		return details.get();
	}

}
