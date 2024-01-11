package com.bim.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Publisher {
	@Id
	@Column(name="PUBLISHERID")
	private int publisherID;
	@Column(name="NAME")
	private String name;
	@Column(name="CITY")
	private String city;
	@ManyToOne
	@JoinColumn(name = "STATECODE")
	private State state;
	
	public Publisher() {
		super();
	}

	public Publisher(int publisherID, String name, String city, State state) {
		super();
		this.publisherID = publisherID;
		this.name = name;
		this.city = city;
		this.state = state;
	}

	public int getPublisherID() {
		return publisherID;
	}

	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
