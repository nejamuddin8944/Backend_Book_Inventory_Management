package com.bim.exceptions;

import com.bim.response.AppResponse;


public class DuplicateUserException extends RuntimeException {
	
	AppResponse appResponse;

	public DuplicateUserException(AppResponse appResponse) {
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

