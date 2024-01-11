package com.bim.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bim.entities.State;

@Service
public interface StateService {
	
	 Boolean addState(State state);
	 Boolean updateStateNameByCode(String stateCode,String name);
	 State getStateByCode(String stateCode);
	 
	 List<State> getAllStates();
	

}
