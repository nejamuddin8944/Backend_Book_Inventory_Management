package com.bim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.bim.entities.BookReview;
import com.bim.entities.BookReviewId;

@Service
public interface BookReviewRepository extends JpaRepository<BookReview, BookReviewId>{

	
	@Query("SELECT b FROM BookReview b where b.id.isbn=:isbn")
	List<BookReview> findAllByIsbn(@Param("isbn") String isbn);
}
