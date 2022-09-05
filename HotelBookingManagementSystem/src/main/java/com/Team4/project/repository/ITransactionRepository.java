package com.Team4.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.project.entity.Transactions;

public interface ITransactionRepository extends JpaRepository<Transactions,Integer>{

}
