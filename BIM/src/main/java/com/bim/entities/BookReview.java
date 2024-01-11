package com.bim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;

import jakarta.persistence.Entity;
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
@Table(name = "bookreview")
public class BookReview {
	 
	    @EmbeddedId
	    private BookReviewId id;
	 
	    @Column(name = "Rating")
	    private Integer rating;
	 
	    @Column(name = "Comments", length = 255)
	    private String comments;
	 
	    @ManyToOne
	    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN", insertable = false, updatable = false)
	    private Book book;
	 
	    @ManyToOne
	    @JoinColumn(name = "ReviewerID", referencedColumnName = "ReviewerID", insertable = false, updatable = false)
	    private Reviewer reviewer;
	 
	 
}
	

