package com.Team4.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.project.entity.Transaction;
import com.Team4.project.repository.TransactionRepo;

@Service
public class TransactionServiceImpl implements   TransactionService{
	@Autowired
	TransactionRepo repo;

	@Override
	public Transaction addTtransaction(Transaction transaction) {
		this.repo.save(transaction);
		return transaction;
	}

	@Override
	public List<Transaction> ListAllTransaction(Transaction transaction) {
	return	this.repo.findAll();
	}

	@Override
	public void deleteTransaction(int Id) {
		
		this.repo.deleteById(Id);
		
		
	}

}
