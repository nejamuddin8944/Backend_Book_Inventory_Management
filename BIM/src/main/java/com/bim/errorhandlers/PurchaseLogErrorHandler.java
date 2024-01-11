package com.bim.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bim.exceptions.DuplicatePurchaseLogException;
import com.bim.exceptions.DuplicateUserException;
import com.bim.exceptions.NullPurchaseLogListException;
import com.bim.exceptions.NullUserListException;
import com.bim.exceptions.PurchaseLogNotFoundException;
import com.bim.exceptions.UserNotFoundException;
import com.bim.response.AppResponse;

public class PurchaseLogErrorHandler {

	@ExceptionHandler(DuplicatePurchaseLogException.class)
	public ResponseEntity<AppResponse> handleDuplicatePurchaseLogException(DuplicatePurchaseLogException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(PurchaseLogNotFoundException.class)
	public ResponseEntity<AppResponse> handlePurchaseLogNotFoundException(PurchaseLogNotFoundException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NullPurchaseLogListException.class)
	public ResponseEntity<AppResponse> handleNullPurchaseLogListException(NullPurchaseLogListException ex){
		return new ResponseEntity<AppResponse>(ex.getAppResponse(),HttpStatus.BAD_REQUEST);
		
	}

}
