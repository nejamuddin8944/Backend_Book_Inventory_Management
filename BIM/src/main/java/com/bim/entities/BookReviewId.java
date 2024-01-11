package com.bim.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class BookReviewId implements Serializable {
	 
	    @Column(name = "ISBN")
	    private String isbn;
	 
	    @Column(name = "ReviewerID")
	    private Integer reviewerId;
	 
	    
}
