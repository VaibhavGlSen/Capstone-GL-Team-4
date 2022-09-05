package com.Team4.project.entity;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int room_id;
	private int hotel_id;
	private String room_no;
	private String room_type;
	private double rate_per_day;
	private Boolean isavailable;
	private Blob photo;
	
	@ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "hotel_id",
            referencedColumnName = "hotel_id"
    )
	private Hotel hotel;

}
