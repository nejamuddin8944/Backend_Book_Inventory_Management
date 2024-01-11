package com.bim.controller;

import java.util.Map;
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
import com.bim.entities.Reviewer;
import com.bim.response.AppResponse;
import com.bim.serviceImpl.ReviewerServiceImpl;

@RestController
@RequestMapping("/api")
public class ReviewerController {

	@Autowired
	ReviewerServiceImpl service;
	
	@GetMapping(value = "/reviewer/{reviewerID}")
	public ResponseEntity<Reviewer> getReviewerById(@PathVariable int reviewerID) {
		Reviewer reviewer = service.getReviewerByID(reviewerID);
		return new ResponseEntity<Reviewer>(reviewer,HttpStatus.OK);
	}

	@PostMapping(value = "/reviewer/post")
	public ResponseEntity<AppResponse> addReviewer(@RequestBody Reviewer reviewer) {
		service.addreviewer(reviewer);
		AppResponse response = new AppResponse("POSTSUCCESS", "Reviewer added successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/reviewer/name/{reviewerId}")
	public ResponseEntity<AppResponse> updateNameById(@PathVariable int reviewerId ,@RequestBody Map<String, String> request){
		String newName = request.get("name");
		service.updateName(reviewerId, newName);
		AppResponse response = new AppResponse("UPDT-NAME-SUCCESS", "Name of the reviewer"+reviewerId+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping(value = "/reviewer/employedby/{reviewerId}")
	public ResponseEntity<AppResponse> updateEmployedById(@PathVariable int reviewerId ,@RequestBody Map<String, String> request){
		String newEmployedBy = request.get("employedBy");
		service.updateEmployed(reviewerId, newEmployedBy);
		AppResponse response = new AppResponse("UPDT-EMPLOYEDBY-SUCCESS", "EmployedBy of the reviewer"+reviewerId+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	           
}


