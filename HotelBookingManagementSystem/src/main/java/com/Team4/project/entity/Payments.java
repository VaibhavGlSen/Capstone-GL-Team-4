package com.Team4.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Payments {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int payment_id;
	private int booking_id;
	private int transaction_id;
	
	@OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
@JoinColumn(name = "transaction_id",referencedColumnName = "transaction_id")
private Transactions transactions;
}
