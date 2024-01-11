package com.bim.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INVENTORY")
public class Inventory{
	
	    @Id
	    @Column(name = "INVENTORYID")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int inventoryId;
	
	    
	    @ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="ISBN",nullable=false)
		private Book isbn;
		
	 
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="Ranks",nullable=false)
		private BookCondition ranks;
		
		@Column(name="Purchased", columnDefinition="TINYINT(1)")              
		private int purchased;
	    
	  
	}
	
	