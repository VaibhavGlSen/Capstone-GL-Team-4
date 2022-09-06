package com.Team4.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.project.entity.Transaction;
import com.Team4.project.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	@PostMapping("/")
	public String addTransaction(@RequestBody Transaction transaction) {
		
		this.service.addTtransaction(transaction);
		return "Transaction in processed";
		
	}
	
	@GetMapping("/")
	public List<Transaction>listAllTransaction(@RequestBody Transaction transaction){
		
		return this.service.ListAllTransaction(transaction);
	
	}
	
	@DeleteMapping("/delete/{Id}")
	public String deleteTransaction(@PathVariable int Id) {
		this.service.deleteTransaction(Id);
		
		return "Transaction reverted successfully";
	}

}
