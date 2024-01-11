package com.bim.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "\"USER\"")
public class User {
	@Id
	
	private int userId;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String userName;
	private String password;
	
	@ManyToOne
	@JoinColumn(name="ROLENUMBER")	
	private PermRole perm; 
	
	
}
