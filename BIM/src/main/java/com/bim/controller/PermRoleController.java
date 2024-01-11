package com.bim.controller;

import java.util.Map;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.entities.Book;
import com.bim.entities.PermRole;
import com.bim.repositories.PermRoleRepository;
import com.bim.response.AppResponse;
import com.bim.serviceImpl.PermRoleServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value="/api")
public class PermRoleController {
	
	@Autowired
	PermRoleServiceImpl service;
	
	
	@PostMapping(value = "/permrole/post")
	public ResponseEntity<AppResponse> addPermRole(@RequestBody PermRole permRole) {
		service.addPermRole(permRole);
		AppResponse response = new AppResponse("POSTSUCCESS", "PERMROLE added successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/permrole/{rolenumber}")
	public ResponseEntity<PermRole> getPermRoleByRoleNumber(@PathVariable("rolenumber") int roleNumber) {
		PermRole permrole  = service.getPermroleByRoleNumber(roleNumber);
		return new ResponseEntity<PermRole>(permrole,HttpStatus.OK);
	}
	
	@PutMapping(value = "/permrole/update/perm/{rolenumber}")
	public ResponseEntity<AppResponse> updatePermByRoleNumber(@PathVariable("rolenumber") int roleNumber ,@RequestBody Map<String, String> request){
		String newPerm = request.get("perm");
		service.updatePerm(roleNumber, newPerm);
		AppResponse response = new AppResponse("UPDATE_PERMROLE_SUCCESS", "Permrole"+roleNumber+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	
	
}
