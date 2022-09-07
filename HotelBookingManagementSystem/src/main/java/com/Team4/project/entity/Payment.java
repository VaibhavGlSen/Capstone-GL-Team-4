package com.Team4.project.entity;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payment_id;
	
	@Column
	private int booking_id;
	
	@Column
	private int transaction_id;
	
	@OneToOne
	private Transaction transaction;

	public Payment() {
		
	}

	public Payment(int payment_id, int booking_id, int transaction_id, Transaction transaction) {
		super();
		this.payment_id = payment_id;
		this.booking_id = booking_id;
		this.transaction_id = transaction_id;
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

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", booking_id=" + booking_id + ", transaction_id=" + transaction_id
				+ ", transaction=" + transaction + "]";
	}
}
