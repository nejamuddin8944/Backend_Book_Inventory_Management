package com.bim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.bim.entities.Author;
import com.bim.entities.Book;


@Service
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	
	

	@Query("SELECT a FROM Author a WHERE a.firstName = :firstName")
	Author findByFirstname(@Param("firstName") String firstName);
	
	@Query("SELECT a FROM Author a WHERE a.lastName = :lastName")
	Author findByLastname(@Param("lastName") String lastName);
	

//	@Query("SELECT a FROM Author a WHERE a.id = :id")
//	 List<Book> findByAuthor(@Param("id") int id);
	


}
