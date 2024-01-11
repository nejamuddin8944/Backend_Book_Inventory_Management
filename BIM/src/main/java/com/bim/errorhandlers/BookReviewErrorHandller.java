package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.BookReviewNotFoundException;
import com.bim.exceptions.DuplicateBookReviewException;
import com.bim.exceptions.NullBookReviewListException;
import com.bim.response.AppResponse;

@ControllerAdvice
public class BookReviewErrorHandller {

	@ExceptionHandler(DuplicateBookReviewException.class)
	public ResponseEntity<AppResponse> handleDuplicateBookReviewException(DuplicateBookReviewException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(BookReviewNotFoundException.class)
	public ResponseEntity<AppResponse> handlePublisherNotFoundException(BookReviewNotFoundException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NullBookReviewListException.class)
	public ResponseEntity<AppResponse> handleNullPublisherListException(NullBookReviewListException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
}
