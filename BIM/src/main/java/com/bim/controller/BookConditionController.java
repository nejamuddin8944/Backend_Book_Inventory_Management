package com.bim.controller;

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

import com.bim.entities.Book;
import com.bim.entities.BookCondition;
import com.bim.repositories.BookConditionRepository;
import com.bim.response.AppResponse;
import com.bim.serviceImpl.BookConditionServiceImpl;
import com.bim.serviceImpl.BookServiceImpl;

@RestController
@RequestMapping("/api")
public class BookConditionController {
	
	@Autowired
	BookConditionServiceImpl service;
	
	@GetMapping("/bookcondition/{ranks}")
	public ResponseEntity<BookCondition> getBookConditionByRanks(@PathVariable int ranks) {
		BookCondition bookCondition = service.getBookConditionByRanks(ranks);
		return new ResponseEntity<BookCondition>(bookCondition,HttpStatus.OK);
	}
	
	@PostMapping("/bookcondition/post")
	public ResponseEntity<AppResponse> addBookCondition(@RequestBody BookCondition bookcondition) {
		service.addBookCondition(bookcondition);
		AppResponse response = new AppResponse("POST-SUCCESS", "Bookcondition added successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/bookcondition/update/description/{ranks}")
	public ResponseEntity<AppResponse> updateDescriptionByRanks(@PathVariable int ranks ,@RequestBody Map<String, String> request){
		String newDescription = request.get("description");
		service.updateDescription(ranks,newDescription);
		AppResponse response = new AppResponse("UPDT-DESCRIPTION-SUCCESS", "Description of the bookcondition" + ranks + " successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping("/bookcondition/update/fullDescription/{ranks}")
	public ResponseEntity<AppResponse> updateFullDescriptionByRanks(@PathVariable int ranks ,@RequestBody Map<String, String> request){
		String newFullDescription = request.get("fullDescription");
		service.updateFullDescription(ranks, newFullDescription);
		AppResponse response = new AppResponse("UPDT-FULLDESCRIPTION-SUCCESS", "FullDescription of the bookcondition" + ranks + " successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping("/bookcondition/update/price/{ranks}")
	public ResponseEntity<AppResponse> updatePriceByranks(@PathVariable int ranks ,@RequestBody Map<String, Double> request){
		Double newPrice = request.get("price");
		service.updatePrice(ranks, newPrice);
		AppResponse response = new AppResponse("UPDT-PRICE-SUCCESS", "Price of the book condition " + ranks + " successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	
}