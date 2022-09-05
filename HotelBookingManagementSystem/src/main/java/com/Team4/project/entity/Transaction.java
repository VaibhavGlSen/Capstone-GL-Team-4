package com.Team4.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	int transaction_id;
	
	double amount;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transaction_id, double amount) {
		super();
		this.transaction_id = transaction_id;
		this.amount = amount;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", amount=" + amount + "]";
	}
	
	

}
