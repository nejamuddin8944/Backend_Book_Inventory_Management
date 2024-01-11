package com.bim.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.entities.State;
import com.bim.repositories.StateRepositories;
import com.bim.response.AppResponse;
import com.bim.services.StateService;

@RestController
@RequestMapping("/api")
public class StateController {

	@Autowired
	StateService service;
	
	@PostMapping("/state/post")
	public ResponseEntity<AppResponse> addState(@RequestBody State state){
		service.addState(state);
		AppResponse response = new AppResponse("POSTSUCCESS", "State added successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/states")
	public List<State> getAllStates() {
		List<State> stateList = service.getAllStates();
		return stateList;
	}
	
	@GetMapping("/state/{stateId}")
	public State getStateById(@PathVariable String stateId) {
		State state = service.getStateByCode(stateId);
		return state;
	}
	@PutMapping("/state/update/name/{stateId}")
	public ResponseEntity<AppResponse> updateStateNameById(@PathVariable String stateId , @RequestBody Map<String, String> request) {
		String name = request.get("name");
		service.updateStateNameByCode(stateId, name);
		AppResponse response = new AppResponse("UPDT-STATE-NAME-BY-ID-SUCCESS", "State name succesfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	
	
	
}
