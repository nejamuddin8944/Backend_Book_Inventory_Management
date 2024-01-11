package com.bim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.PermRole;

@Service
public interface PermRoleRepository extends JpaRepository<PermRole, Integer>{

	

	 
	 
}