package com.bim.exceptions;

import com.bim.response.AppResponse;

public class DuplicateBookConditionException extends RuntimeException {

	AppResponse appResponse;

	public DuplicateBookConditionException(AppResponse appResponse) {
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
