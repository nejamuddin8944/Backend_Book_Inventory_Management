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

import com.bim.entities.Publisher;
import com.bim.entities.State;
import com.bim.response.AppResponse;
import com.bim.serviceImpl.PublisherServiceImpl;

@RestController
@RequestMapping("/api")
public class PublisherController {

	@Autowired
	PublisherServiceImpl service;
	
	@PostMapping(value = "/publisher/post")
	public ResponseEntity<AppResponse> addPublisher(@RequestBody Publisher publisher) {
		service.addPublisher(publisher);
		AppResponse response = new AppResponse("POSTSUCCESS", "Publisher added successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/publisher")
	public ResponseEntity<List<Publisher>> getAllPublishers(){
		List<Publisher> publisherList = service.getAllPublisher();
		return new ResponseEntity<List<Publisher>>(publisherList,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/publisher/{publisherID}")
	public ResponseEntity<Publisher> getPublisherById(@PathVariable int publisherID) {
		Publisher publisher = service.getPublisherByPublisherID(publisherID);
		return new ResponseEntity<Publisher>(publisher,HttpStatus.OK);
	}
	
	@GetMapping(value = "/publisher/name/{name}")
	public ResponseEntity<Publisher> getPublisherByName(@PathVariable String name) {
		Publisher publisher = service.getPublisherByName(name);
		return new ResponseEntity<Publisher>(publisher,HttpStatus.OK);
	}
	
	@GetMapping(value = "/publisher/city/{city}")
	public ResponseEntity<List<Publisher>> getPublisherByCity(@PathVariable String city) {
		List<Publisher> publisherListByCity = service.getAllPublisherByCity(city);
		return new ResponseEntity<List<Publisher>>(publisherListByCity,HttpStatus.OK);
	}
	
	@GetMapping(value = "/publisher/state/{state}")
	public ResponseEntity<List<Publisher>> getPublisherByState(@PathVariable String state) {
		List<Publisher> publisherListByState = service.getAllPublisherByState(state);
		return new ResponseEntity<List<Publisher>>(publisherListByState,HttpStatus.OK);
	}
	
	@PutMapping("/publisher/update/city/{publisherId}")
	public ResponseEntity<AppResponse> updateCityById(@PathVariable int publisherId ,@RequestBody Map<String, String> request){
		String newCity = request.get("city");
		service.updateCity(publisherId, newCity);
		AppResponse response = new AppResponse("UPDT-CITY-SUCCESS", "CITY of the publisher "+publisherId+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping("/publisher/update/state/{publisherId}")
	public ResponseEntity<AppResponse> updateStateById(@PathVariable int publisherId ,@RequestBody Map<String, State> request){
		State newState = request.get("state");
		service.updateState(publisherId, newState);
		AppResponse response = new AppResponse("UPDT-STATE-SUCCESS", "State of the publisher "+publisherId+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	
}
