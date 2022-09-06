package com.Team4.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.project.entity.BookingDetails;
import com.Team4.project.entity.Payment;
import com.Team4.project.entity.Transaction;
import com.Team4.project.repository.PaymentRepo;
import com.Team4.project.repository.TransactionRepo;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentRepo repo;
	
	@Autowired
	TransactionRepo trepo;

	@Override
	public Payment addPayment(Payment payment) {
		
Transaction transactionDetails=trepo.findById(payment.getTransaction().getTransaction_id()).get();

		payment.setTransaction(transactionDetails);
		this.repo.save(payment);
		return payment;
		
	}

}
