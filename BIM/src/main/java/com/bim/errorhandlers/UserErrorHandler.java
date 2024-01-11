package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.DuplicateUserException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.exceptions.NullUserListException;
import com.bim.exceptions.UserNotFoundException;
import com.bim.response.AppResponse;

@ControllerAdvice
public class UserErrorHandler {
	
	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<AppResponse> handleDuplicateUserException(DuplicateUserException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<AppResponse> handleUserNotFoundException(UserNotFoundException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NullUserListException.class)
	public ResponseEntity<AppResponse> handleNullUserListException(NullUserListException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}


}
