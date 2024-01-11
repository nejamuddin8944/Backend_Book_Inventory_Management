package com.bim.services;

import org.springframework.stereotype.Service;

import com.bim.entities.User;
@Service
public interface UserService {
	Boolean addUser(User use);
	
	User getUserByUserId(int userId);
	
	Boolean updateFirstName(int userId, String firstName);
	Boolean updateLastName(int userId, String lastName);
	Boolean updatePhoneNumber(int userId, String phoneNumber);
	

}
