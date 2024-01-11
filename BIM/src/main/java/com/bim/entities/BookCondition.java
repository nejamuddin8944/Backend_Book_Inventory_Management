package com.bim.entities;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "BOOKCONDITION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCondition {
	@Id
	@Column(name = "RANKS")
	private int ranks;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "FULLDESCRIPTION")
	private String fullDescription;
	@Column(name = "PRICE")
	private double price;
	


	
}
	
	