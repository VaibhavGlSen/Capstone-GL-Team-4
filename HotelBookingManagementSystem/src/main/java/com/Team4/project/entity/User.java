package com.Team4.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="UserId")
	int user_id;
	
	@Column(name="Username")

	String user_name;
	
	@Column(name="Email")

	String email;
	
	@Column(name="Password")

	String password;
	
	@Column(name="Role")

	String role;

	@Column(name="Mobile")

	String mobile;

	@Column(name="Address")

	String address;
	
	
	@OneToOne
	BookingDetails bookingDetail;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int user_id, String user_name, String email, String password, String role, String mobile,
			String address, BookingDetails bookingDetail) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
		this.bookingDetail = bookingDetail;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public BookingDetails getBookingDetail() {
		return bookingDetail;
	}


	public void setBookingDetail(BookingDetails bookingDetail) {
		this.bookingDetail = bookingDetail;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", mobile=" + mobile + ", address=" + address + ", bookingDetail=" + bookingDetail
				+ "]";
	}
	
	
	
	

}
