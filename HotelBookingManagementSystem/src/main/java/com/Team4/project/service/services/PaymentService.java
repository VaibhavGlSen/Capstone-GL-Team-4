package com.Team4.project.service.services;

import org.springframework.stereotype.Service;

import com.Team4.project.entity.Payment;

@Service
public interface PaymentService {
	
	public Payment addPayment(Payment payment);
}
