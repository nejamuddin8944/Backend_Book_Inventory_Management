package com.bim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
    
	@Entity
	@Table(name="reviewer")
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public class Reviewer {
	    
		@Id
		@Column(name = "REVIEWERID")
		private int reviewerId;
		@Column(name = "NAME")
		private String name;
		@Column(name = "EMPLOYEDBY")
		private String employedBy;
		
	
		
}

