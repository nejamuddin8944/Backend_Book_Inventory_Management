package com.bim.entities;
import com.bim.entities.Author;
import com.bim.entities.Book;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookauthor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthor {
	@EmbeddedId
    private BookAuthorId id;
 
    @Column(name = "PRIMARYAUTHOR", length = 1)
    private String primaryAuthor;
 
    @ManyToOne
    @JoinColumn(name = "AuthorID", referencedColumnName = "authorID", insertable = false, updatable = false)
    private Author author;
 
    @ManyToOne
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN", insertable = false, updatable = false)
    private Book book;
 
    

}
