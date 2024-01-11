package com.bim.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "Author")

public class Author {
	@Id
	@Column(name = "AUTHORID" )
	private int id;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "PHOTO")
	private String photo;
	
	
	
	
}
