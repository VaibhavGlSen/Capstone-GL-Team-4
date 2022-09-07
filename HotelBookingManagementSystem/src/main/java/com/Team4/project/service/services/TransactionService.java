package com.Team4.project.service.services;

import org.springframework.stereotype.Service;

import com.Team4.project.entity.Transaction;

@Service
public interface TransactionService {
	
	public Transaction addTransaction(Transaction transaction);
}
