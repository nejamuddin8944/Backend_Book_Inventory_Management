package com.bim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.Publisher;

@Service
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

	@Query("SELECT p FROM Publisher p WHERE p.name = :name")
	Publisher findByName(@Param("name") String name);
	
	@Query("SELECT p FROM Publisher p WHERE p.city = :city")
	List<Publisher> findByCity(@Param("city") String city);

	@Query("SELECT p FROM Publisher p WHERE p.state.stateName = :stateName")
	List<Publisher> findByState(@Param("stateName") String stateName);

}
