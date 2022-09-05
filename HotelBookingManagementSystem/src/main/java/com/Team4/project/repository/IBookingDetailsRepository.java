package com.Team4.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.project.entity.BookingDetails;

public interface IBookingDetailsRepository  extends JpaRepository<BookingDetails,Integer>{

}
