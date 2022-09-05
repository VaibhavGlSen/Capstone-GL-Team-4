package com.Team4.project.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int booking_id;
	private int hotel_id;
	private int room_id;
	private int user_id;
	private Date booked_from;
	private Date booked_to;
	private int no_of_adults;
	private int no_of_children;
	private double amount;
	
	 @OneToOne(
	            cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            optional = false)
	@JoinColumn(name = "user_id",referencedColumnName = "user_id")
	private User user;
	 
	 @OneToMany(
	            cascade = CascadeType.ALL
	    )
	    @JoinColumn(
	            name = "payment_id",
	            referencedColumnName = "payment_id"
	    )
	    private Payments payments;
	 
	 @OneToMany(
	            cascade = CascadeType.ALL
	    )
	    @JoinColumn(
	            name = "room_id",
	            referencedColumnName = "room_id"
	    )
	    private RoomDetails roomDetails;

	 @OneToOne(
	            cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            optional = false)
	@JoinColumn(name = "hotel_id",referencedColumnName = "hotel_id")
	private Hotel hotel;
}
