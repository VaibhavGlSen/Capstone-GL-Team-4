package com.Team4.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int hotel_id;
	private String city;
	private String hotel_name;
	private String address;
	private String description;
	private double avg_rate_per_day;
	private String email;
	private String phone1;
	private String phone2;
	private String website;
}
