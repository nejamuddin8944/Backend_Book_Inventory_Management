package com.bim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.bim.entities.State;

@Service
public interface StateRepositories extends JpaRepository<State, String>{

}
