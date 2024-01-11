package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.DuplicateStateException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.exceptions.NullStateListExceptione;
import com.bim.exceptions.StateNotFoundException;
import com.bim.response.AppResponse;

@ControllerAdvice
public class StateErrorHandler {

	@ExceptionHandler(DuplicateStateException.class)
	public ResponseEntity<AppResponse> handleDuplicateStateException(DuplicateStateException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(StateNotFoundException.class)
	public ResponseEntity<AppResponse> handleStateNotFoundException(DuplicateStateException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NullStateListExceptione.class)
	public ResponseEntity<AppResponse> handleNullStateListException(NullBookListExceptione ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NO_CONTENT);
		
	}
}
