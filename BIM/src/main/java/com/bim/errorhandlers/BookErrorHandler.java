package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.response.AppResponse;

@ControllerAdvice
public class BookErrorHandler {
	
	@ExceptionHandler(DuplicateBookException.class)
	public ResponseEntity<AppResponse> handleDuplicateBookException(DuplicateBookException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<AppResponse> handleBookNotFoundException(BookNotFoundException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NullBookListExceptione.class)
	public ResponseEntity<AppResponse> handleNullBookListException(NullBookListExceptione ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NO_CONTENT);
		
	}

}
