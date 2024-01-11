package com.bim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.bim.entities.Category;

@Service
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
