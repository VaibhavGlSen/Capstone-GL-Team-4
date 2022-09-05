package com.Team4.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.project.entity.Payments;

public interface IPaymentRepository extends JpaRepository<Payments,Integer>{

}
