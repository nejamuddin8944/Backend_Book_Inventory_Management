package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.DuplicatePublisherException;
import com.bim.exceptions.NullPublisherListException;
import com.bim.exceptions.PublisherNotFoundException;
import com.bim.response.AppResponse;

@ControllerAdvice
public class PublisherErrorHandler {

	@ExceptionHandler(DuplicatePublisherException.class)
	public ResponseEntity<AppResponse> handleDuplicatePublisherException(DuplicatePublisherException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(PublisherNotFoundException.class)
	public ResponseEntity<AppResponse> handlePublisherNotFoundException(PublisherNotFoundException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NullPublisherListException.class)
	public ResponseEntity<AppResponse> handleNullPublisherListException(NullPublisherListException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NO_CONTENT);
		
	}
	
}
