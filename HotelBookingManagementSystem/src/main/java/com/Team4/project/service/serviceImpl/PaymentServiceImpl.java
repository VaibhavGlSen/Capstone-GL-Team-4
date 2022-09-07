package com.Team4.project.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Team4.project.entity.Payment;
import com.Team4.project.repository.IPaymentRepository;
import com.Team4.project.service.services.PaymentService;

@Component
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	IPaymentRepository repo;

	@Override
	public Payment addPayment(Payment payment) {
		repo.save(payment);
		return payment;
	}

}
