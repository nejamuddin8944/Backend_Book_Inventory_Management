package com.bim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permrole")
public class PermRole {
	
	@Id
	@Column(name="ROLENUMBER")
	private int roleNumber;
	
	@Column(name="PERMROLE")
	private String perm;
	
	
}
	
	