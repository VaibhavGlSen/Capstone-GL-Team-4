package com.Team4.project.service;

import java.util.List;

import com.Team4.project.entity.Transaction;

public interface TransactionService {
	
	public Transaction addTtransaction(Transaction transaction);
	
	public List<Transaction> ListAllTransaction(Transaction transaction);
	
	public void deleteTransaction(int Id);

}
