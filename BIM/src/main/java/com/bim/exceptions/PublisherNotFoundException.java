package com.bim.exceptions;

import com.bim.response.AppResponse;

public class PublisherNotFoundException extends RuntimeException {

	AppResponse appResponse;

	public PublisherNotFoundException(AppResponse appResponse) {
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
