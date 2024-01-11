package com.bim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
	
	@Id
	@Column(name="CATID")
	private int catID;
	@Column(name="CATDESCRIPTION")
	private String catDescription;
	
	public Category() {
		super();
	}

	public Category(int catId, String catDescription) {
		super();
		this.catID = catId;
		this.catDescription = catDescription;
	}

	public int getCatId() {
		return catID;
	}

	public void setCatId(int catId) {
		this.catID = catId;
	}

	public String getCatDescription() {
		return catDescription;
	}

	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}
	
	
}
