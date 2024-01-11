package com.bim.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bim.entities.Reviewer;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Integer>{

}


