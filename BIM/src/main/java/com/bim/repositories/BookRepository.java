package com.bim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;

@Service
public interface BookRepository extends JpaRepository<Book, String>{

	 @Query("SELECT b FROM Book b WHERE b.title = :title")
	 List<Book> findByTitle(@Param("title") String title);
	 
	 @Query("SELECT b FROM Book b WHERE b.category.catID = :catID")
	 List<Book> findByCategory(@Param("catID") int catID);
	 
	 @Query("SELECT b FROM Book b WHERE b.publisher.publisherID = :publisherID")
	 List<Book> findByPublisher(@Param("publisherID") int publisherID);
	 
}
