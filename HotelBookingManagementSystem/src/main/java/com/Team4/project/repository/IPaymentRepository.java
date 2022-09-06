package com.Team4.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Team4.project.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{

}
