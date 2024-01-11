package com.bim.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.User;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateUserException;
import com.bim.exceptions.UserNotFoundException;
import com.bim.repositories.UserRepository;
import com.bim.response.AppResponse;
import com.bim.services.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public Boolean addUser(User use) {
		Optional<User> opt = userRepo.findById(use.getUserId());
		if(opt.isPresent()) {
			throw new DuplicateUserException(new AppResponse("ADD_FAIL", "User already exists"));
		}
		userRepo.save(use);
		return true;		
	}

	@Override
	public User getUserByUserId(int userId) {
	  Optional<User> opt = userRepo.findById(userId);
	  if(opt.isPresent())
	  {
		  return opt.get();
	  }
	  throw new UserNotFoundException(new AppResponse("GET_USER_BY_USERID_FAIL", "User not found"));
	}

	@Override
	public Boolean updateFirstName(int userId, String firstName) {
		Optional<User> opt = userRepo.findById(userId);
		if (opt.isPresent()) {

			User user1 = opt.get();
			user1.setFirstName(firstName); 
			userRepo.save(user1);
			return true;
		}
		throw new UserNotFoundException(new AppResponse("UPDT_FIRSTNAME_FAIL", "User doesn't exist"));
	}
	

	@Override
	public Boolean updateLastName(int userId, String lastName) {
		Optional<User> opt =userRepo.findById(userId);
		if(opt.isPresent()) {
			User user1=opt.get();
			user1.setLastName(lastName);
			userRepo.save(user1);
		return true;
		}
		throw new UserNotFoundException(new AppResponse("UPDATE_LASTNAME_FAIL", "User does not exists"));
		
	}

	@Override
	public Boolean updatePhoneNumber(int userId, String phoneNumber) {
		Optional<User> opt =userRepo.findById(userId);
		if(opt.isPresent()) {
			User user1=opt.get();
			user1.setPhoneNumber(phoneNumber);
			userRepo.save(user1);
		return true;
		}
		throw new UserNotFoundException(new AppResponse("UPDATE_PHONENUMBER_FAIL", "User does not exists"));
	}
}
