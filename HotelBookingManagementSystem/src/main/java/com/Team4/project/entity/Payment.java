package com.Team4.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	
	@Column(name="PaymentId")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	int payment_id;
	
	@Column(name="BookingId")

	int booking_id;
	
	@Column(name="TransactionId")

	int transaction_id;
	
	@ManyToOne
	
	BookingDetails bookingDetails;
	
	@OneToOne
	Transaction transaction;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int payment_id, int booking_id, int transaction_id, BookingDetails bookingDetails,
			Transaction transaction) {
		super();
		this.payment_id = payment_id;
		this.booking_id = booking_id;
		this.transaction_id = transaction_id;
		this.bookingDetails = bookingDetails;
		this.transaction = transaction;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", booking_id=" + booking_id + ", transaction_id=" + transaction_id
				+ ", bookingDetails=" + bookingDetails + ", transaction=" + transaction + "]";
	}
	
	

}
