package com.Team4.project.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RoomDetails")
public class RoomDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int room_id;
		

	String room_no;
	

	String room_type;
	

	double rate_per_day;
	

	Boolean isavailable;
	

	String photoURL;

	public RoomDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomDetails(int room_id, String room_no, String room_type, double rate_per_day,
			Boolean isavailable,String photoURL) {
		super();
		this.room_id = room_id;
		this.room_no = room_no;
		this.room_type = room_type;
		this.rate_per_day = rate_per_day;
		this.isavailable = isavailable;
		this.photoURL = photoURL;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}



	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public double getRate_per_day() {
		return rate_per_day;
	}

	public void setRate_per_day(double rate_per_day) {
		this.rate_per_day = rate_per_day;
	}

	public Boolean getIsavailable() {
		return isavailable;
	}

	public void setIsavailable(Boolean isavailable) {
		this.isavailable = isavailable;
	}

	public String getPhoto() {
		return photoURL;
	}

	public void setPhoto(String photoURL) {
		this.photoURL = photoURL;
	}

	@Override
	public String toString() {
		return "RoomDetails [room_id=" + room_id + ", room_no=" + room_no + ", room_type="
				+ room_type + ", rate_per_day=" + rate_per_day + ", isavailable=" + isavailable + ", photoURL=" + photoURL
				+ "]";
	}
	
	

}
