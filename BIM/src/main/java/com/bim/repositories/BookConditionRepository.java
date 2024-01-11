package com.bim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bim.entities.BookCondition;

@Repository
public interface BookConditionRepository extends JpaRepository<BookCondition, Integer> {

}
