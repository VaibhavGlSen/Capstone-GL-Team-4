package com.Team4.project.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="booking_details")
public class BookingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int booking_id;
	
	@Column
	private int hotel_id;
	
	@Column
	private int room_id;
	
	@Column
	private int user_id;
	
	@Column
	private Date booked_from;
	
	@Column
	private Date booked_to;
	
	@Column
	private int no_of_adults;
	
	@Column
	private int no_of_children;
	
	@Column
	private double amount;
	
	@OneToOne
	private User user;
	
	@OneToMany
	private List<Payment> payment;
	
	@OneToMany
	private List<RoomDetails> room_details; 
	
	@OneToOne
	private Hotel hotel;

	public BookingDetails() {
		
	}

	public BookingDetails(int booking_id, int hotel_id, int room_id, int user_id, Date booked_from, Date booked_to,
			int no_of_adults, int no_of_children, double amount, User user, List<Payment> payment,
			List<RoomDetails> room_details, Hotel hotel) {
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
		this.user = user;
		this.payment = payment;
		this.room_details = room_details;
		this.hotel = hotel;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public List<RoomDetails> getRoom_details() {
		return room_details;
	}

	public void setRoom_details(List<RoomDetails> room_details) {
		this.room_details = room_details;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "BookingDetails [booking_id=" + booking_id + ", hotel_id=" + hotel_id + ", room_id=" + room_id
				+ ", user_id=" + user_id + ", booked_from=" + booked_from + ", booked_to=" + booked_to
				+ ", no_of_adults=" + no_of_adults + ", no_of_children=" + no_of_children + ", amount=" + amount
				+ ", user=" + user + ", payment=" + payment + ", room_details=" + room_details + ", hotel=" + hotel
				+ "]";
	}
}
