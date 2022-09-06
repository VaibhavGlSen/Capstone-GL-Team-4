package com.Team4.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int payment_id;	

	
	
	@OneToOne
	Transaction transaction;


	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Payment(int payment_id, Transaction transaction) {
		super();
		this.payment_id = payment_id;
		this.transaction = transaction;
	}


	public int getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}


	public Transaction getTransaction() {
		return transaction;
	}


	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}


	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", transaction=" + transaction + "]";
	}
	
	

	
	
	

}
