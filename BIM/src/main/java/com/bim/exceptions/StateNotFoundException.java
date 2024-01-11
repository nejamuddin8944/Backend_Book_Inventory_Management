package com.bim.exceptions;

import com.bim.response.AppResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StateNotFoundException extends RuntimeException {

	AppResponse appResponse;
}
