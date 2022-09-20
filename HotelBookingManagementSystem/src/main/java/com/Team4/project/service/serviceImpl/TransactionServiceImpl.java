package com.Team4.project.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Team4.project.entity.Transaction;
import com.Team4.project.repository.ITransactionRepository;
import com.Team4.project.service.services.TransactionService;

@Component
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	ITransactionRepository repo;

	// add Transaction
	@Override
	public Transaction addTransaction(Transaction transaction) {
		repo.save(transaction);
		return transaction;
	}

}
