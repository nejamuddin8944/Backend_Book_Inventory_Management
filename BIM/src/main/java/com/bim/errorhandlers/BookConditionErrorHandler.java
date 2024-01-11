package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.BookConditionNotFoundException;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookConditionException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.NullBookConditionListException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.response.AppResponse;

@ControllerAdvice
public class BookConditionErrorHandler {
	
	@ExceptionHandler(DuplicateBookConditionException.class)
	public ResponseEntity<AppResponse> handleDuplicateBookConditionException(DuplicateBookConditionException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(BookConditionNotFoundException.class)
	public ResponseEntity<AppResponse> handleBookConditionNotFoundException(BookConditionNotFoundException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NullBookConditionListException.class)
	public ResponseEntity<AppResponse> handleNullBookConditionListException(NullBookConditionListException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}


}
