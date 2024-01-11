package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.DuplicatePermRoleException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.exceptions.NullPermRoleListException;
import com.bim.exceptions.PermRoleNotFoundException;
import com.bim.response.AppResponse;

@ControllerAdvice
public class PermRoleErrorHandler {

	@ExceptionHandler(PermRoleNotFoundException.class)
	public ResponseEntity<AppResponse> handlePermRoleNotFoundException(PermRoleNotFoundException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(DuplicatePermRoleException.class)
	public ResponseEntity<AppResponse> handleDuplicatePermRoleException(DuplicatePermRoleException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(NullPermRoleListException.class)
	public ResponseEntity<AppResponse> handleNullPermRoleListException(NullPermRoleListException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
}
