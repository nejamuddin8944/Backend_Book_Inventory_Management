package com.bim.exceptions;

import com.bim.response.AppResponse;

public class DuplicateReviewerException extends RuntimeException {
 
	AppResponse appresponse;

	public DuplicateReviewerException(AppResponse appresponse) {
		super();
		this.appresponse = appresponse;
	}

	public AppResponse getAppresponse() {
		return appresponse;
	}

	public void setAppresponse(AppResponse appresponse) {
		this.appresponse = appresponse;
	}
	
	
}
