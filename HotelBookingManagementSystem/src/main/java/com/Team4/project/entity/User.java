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
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String user_name;
	private String email;
	private String password;
	private String mobile;
	private String role;
	private String address;

}
