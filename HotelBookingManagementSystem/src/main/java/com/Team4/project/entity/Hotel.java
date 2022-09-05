package com.Team4.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
public class Hotel {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HotelId")
	int hotel_id;
	
	@Column(name="City")

	String city;

	@Column(name="HotelName")

	String hotel_name;
	
	@Column(name="Address")

	String address;
	
	@Column(name="Description")

	String description;
	
	@Column(name="Rate")

	double avg_rate_per_day;
	
	@Column(name="Email")

	String email;
	
	@Column(name="Phone1")

	String phone1;
	
	@Column(name="Phone2")

	String phone2;
	
	@Column(name="WebURL")

	String website;
	
	@ManyToOne
	RoomDetails roomDetails;
	
	@OneToOne
	BookingDetails bookingDetails;
	

	
	

}
