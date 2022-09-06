package com.Team4.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.project.entity.BookingDetails;
import com.Team4.project.entity.Payment;
import com.Team4.project.service.BookingDetailsService;
import com.Team4.project.service.PaymentService;

@RestController
@RequestMapping("/bookings")
public class BookingDetailsController {
	
	@Autowired 
	BookingDetailsService service;
	
	@Autowired 
	PaymentService paymentservice;
	
	@PostMapping("/")
	public BookingDetails addBookingDetails(@RequestBody BookingDetails bookingDetails) {
		
		this.service.addBookingDetails(bookingDetails);
		
		return bookingDetails;
	}
	
	@GetMapping("/")
	public List<BookingDetails> listAllBookingDetails(@RequestBody BookingDetails bookingDetails){
		
		return this.service.showAllBookingDetails(bookingDetails);
	}
	
	
	
	@PutMapping("/{booking_id}")
	public ResponseEntity<BookingDetails> updateBookingDetails(@PathVariable int booking_id,@RequestBody BookingDetails bookingDetails) {
		this.service.updateBookingDetails(booking_id, bookingDetails);

		return ResponseEntity.ok(bookingDetails);
	}
	
	
	//get bookingDetails by Id
	
	@GetMapping("/bookings/{booking_id}")
	public BookingDetails showBookingDetailsById(@PathVariable int booking_id,@RequestBody BookingDetails bookingDetails) {
		
		this.service.showBookingDetailsById(bookingDetails, booking_id);
		return bookingDetails;
	}
	
	
	//for payment
	
	@PostMapping("/payments")
	public Payment addPayment(@RequestBody Payment payment) {
		
		this.paymentservice.addPayment(payment);
		return payment;
		
	}
	
	
	
	

}
