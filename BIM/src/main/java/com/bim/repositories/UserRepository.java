package com.bim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.bim.entities.Publisher;
import com.bim.entities.User;

@Service
public interface UserRepository extends JpaRepository<User, Integer>{

}
