package com.Team4.project.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bookingDetails")
public class BookingDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BookingId")

	int booking_id;
	
	@Column(name="HotelId")

	int hotel_id;
	
	@Column(name="RoomId")

	int room_id;
	
	@Column(name="UserId")

	int user_id;
	
	@Column(name="From")

	Date booked_from;
	
	@Column(name="Till")

	Date booked_to;
	
	@Column(name="Adults")

	int no_of_adults;
	
	
	@Column(name="Children")

	int no_of_children;
	
	@Column(name="Amount")

	double amount;
	
	@OneToMany
	
	List<RoomDetails> roomDetails;

	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingDetails(int booking_id, int hotel_id, int room_id, int user_id, Date booked_from, Date booked_to,
			int no_of_adults, int no_of_children, double amount, List<RoomDetails> roomDetails) {
		super();
		this.booking_id = booking_id;
		this.hotel_id = hotel_id;
		this.room_id = room_id;
		this.user_id = user_id;
		this.booked_from = booked_from;
		this.booked_to = booked_to;
		this.no_of_adults = no_of_adults;
		this.no_of_children = no_of_children;
		this.amount = amount;
		this.roomDetails = roomDetails;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getBooked_from() {
		return booked_from;
	}

	public void setBooked_from(Date booked_from) {
		this.booked_from = booked_from;
	}

	public Date getBooked_to() {
		return booked_to;
	}

	public void setBooked_to(Date booked_to) {
		this.booked_to = booked_to;
	}

	public int getNo_of_adults() {
		return no_of_adults;
	}

	public void setNo_of_adults(int no_of_adults) {
		this.no_of_adults = no_of_adults;
	}

	public int getNo_of_children() {
		return no_of_children;
	}

	public void setNo_of_children(int no_of_children) {
		this.no_of_children = no_of_children;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<RoomDetails> getRoomDetails() {
		return roomDetails;
	}

	public void setRoomDetails(List<RoomDetails> roomDetails) {
		this.roomDetails = roomDetails;
	}

	@Override
	public String toString() {
		return "BookingDetails [booking_id=" + booking_id + ", hotel_id=" + hotel_id + ", room_id=" + room_id
				+ ", user_id=" + user_id + ", booked_from=" + booked_from + ", booked_to=" + booked_to
				+ ", no_of_adults=" + no_of_adults + ", no_of_children=" + no_of_children + ", amount=" + amount
				+ ", roomDetails=" + roomDetails + "]";
	}

	
	
	
	
	

}
