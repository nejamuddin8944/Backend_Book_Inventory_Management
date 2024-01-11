package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.DuplicateInventoryException;
import com.bim.exceptions.InventoryNotFoundException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.response.AppResponse;

@ControllerAdvice
public class InventoryErrorHandler {
	
	@ExceptionHandler(DuplicateInventoryException.class)
	public ResponseEntity<AppResponse> handleDuplicateInventoryException(DuplicateInventoryException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(InventoryNotFoundException.class)
	public ResponseEntity<AppResponse> handleInventoryNotFoundException(InventoryNotFoundException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NOT_FOUND);
		
	}
	

}
