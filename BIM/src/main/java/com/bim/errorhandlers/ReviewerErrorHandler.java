package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.DuplicateReviewerException;
import com.bim.exceptions.ReviewerNotFoundException;
import com.bim.response.AppResponse;

@ControllerAdvice
public class ReviewerErrorHandler {

	@ExceptionHandler(DuplicateReviewerException.class)
	public ResponseEntity<AppResponse> handleDuplicateReviewerException(DuplicateReviewerException ex){
		return new ResponseEntity<AppResponse>(ex.getAppresponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ReviewerNotFoundException.class)
	public ResponseEntity<AppResponse> handleReviewerNotFoundException(ReviewerNotFoundException ex){
		return new ResponseEntity<AppResponse>(ex.getAppresponse(),HttpStatus.BAD_REQUEST);
		
	}
	
}
