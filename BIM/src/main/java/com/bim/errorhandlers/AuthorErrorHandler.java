package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.AuthorNotFoundException;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateAuthorException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.NullAuthorListException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.response.AppResponse;

@ControllerAdvice
public class AuthorErrorHandler {

	@ExceptionHandler(DuplicateAuthorException.class)
	public ResponseEntity<AppResponse> handleDuplicateAuthorException(DuplicateAuthorException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<AppResponse> handleAuthorNotFoundException(AuthorNotFoundException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NullAuthorListException.class)
	public ResponseEntity<AppResponse> handleNullAuthorListException(NullAuthorListException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
}
