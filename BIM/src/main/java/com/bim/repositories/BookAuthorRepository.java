package com.bim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bim.entities.Book;
import com.bim.entities.BookAuthor;
import com.bim.entities.BookAuthorId;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorId> {
		
		@Query("SELECT b.book FROM BookAuthor b WHERE b.id.authorId=:authorId")
		List<Book> findAllBooksByAuthor(@Param("authorId") int authorId);
	 
}


