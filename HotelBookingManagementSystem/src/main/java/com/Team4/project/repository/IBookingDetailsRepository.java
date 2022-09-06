package com.Team4.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Team4.project.entity.BookingDetails;

@Repository
public interface IBookingDetailsRepository extends JpaRepository<BookingDetails, Integer>{

}
