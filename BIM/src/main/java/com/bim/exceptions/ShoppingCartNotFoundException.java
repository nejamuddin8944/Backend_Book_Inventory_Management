package com.bim.exceptions;

import com.bim.response.AppResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartNotFoundException extends RuntimeException {

	AppResponse appResponse;
}
