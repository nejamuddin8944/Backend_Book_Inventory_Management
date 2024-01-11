package com.bim.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {
	@Id
	private String isbn;
	private String title;
	private String description;
	private String edition;
	@ManyToOne
	@JoinColumn(name = "CATEGORY")
	private Category category;
	@ManyToOne
	@JoinColumn(name="PUBLISHERID")
	private Publisher publisher;
	
	public String getIsbn() {
		return isbn;
	}

	
	public Book(String isbn, String title, String description, String edition, Category category, Publisher publisher) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.edition = edition;
		this.category = category;
		this.publisher = publisher;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Book() {
		super();
	}
	
	
	
	
}
