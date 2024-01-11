package com.bim.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.entities.Book;
import com.bim.entities.PermRole;
import com.bim.entities.Publisher;
import com.bim.entities.User;

import com.bim.response.AppResponse;
import com.bim.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping(value ="/api")
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	
	@PostMapping(value="/user/post")
	public ResponseEntity<AppResponse> addUser(@RequestBody User use )
	{
		service.addUser(use);
		AppResponse response =new AppResponse("POSTSUCCESS", "User added successfully");
		return new ResponseEntity<AppResponse>(response, HttpStatus.CREATED);	
	}
	
	@GetMapping(value="/user/{userId}")
	public ResponseEntity<User> getUserByUserId(@PathVariable int userId)
	{
		User user =service.getUserByUserId(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PutMapping(value = "/user/update/firstname/{userId}")
	public ResponseEntity<AppResponse> updateFirstNameByUserId(@PathVariable("userId") int userId ,@RequestBody Map<String, String> request)
	{
		String newFirstName = request.get("firstName");
		service.updateFirstName(userId,newFirstName);
		AppResponse response = new AppResponse("UPDT-FIRSTNAME-SUCCESS", "User details of "+userId+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	@PutMapping(value = "/user/update/lastname/{userId}")
	public ResponseEntity<AppResponse> updateLastNameByUserId(@PathVariable int userId ,@RequestBody Map<String, String> request)
	{
		String newLastName = request.get("lastName");
		service.updateLastName(userId, newLastName);
		AppResponse response = new AppResponse("UPDATE_LASTNAME_SUCCESS", "User" +userId+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping(value = "/user/update/phonenumber/{userId}")
	public ResponseEntity<AppResponse> updatePhoneNumberByUserId(@PathVariable int userId ,@RequestBody Map<String, String> request)
	{
		String newPhoneNumber = request.get("phonenumber");
		service.updatePhoneNumber(userId, newPhoneNumber);
		AppResponse response = new AppResponse("UPDATE_PHONENUMBER_SUCCESS", "User" +userId+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	}


