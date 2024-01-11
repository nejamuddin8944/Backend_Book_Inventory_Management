package com.bim.exceptions;

import com.bim.response.AppResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DuplicateCartException extends RuntimeException {

	
	AppResponse reponse;
}
