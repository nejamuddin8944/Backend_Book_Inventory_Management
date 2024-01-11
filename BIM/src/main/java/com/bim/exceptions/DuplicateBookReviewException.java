package com.bim.exceptions;

import com.bim.response.AppResponse;

public class DuplicateBookReviewException extends RuntimeException{
 	
	AppResponse appResponse;

	public DuplicateBookReviewException(AppResponse appResponse) {
		super();
		this.appResponse = appResponse;
	}

	public AppResponse getAppResponse() {
		return appResponse;
	}

	public void setAppResponse(AppResponse appResponse) {
		this.appResponse = appResponse;
	}

}
