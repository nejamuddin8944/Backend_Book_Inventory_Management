package com.bim.controller;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.entities.ShoppingCart;
import com.bim.repositories.ShoppingCartRepository;
import com.bim.response.AppResponse;
import com.bim.serviceImpl.ShoppingCartServiceImpl;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartServiceImpl service;
	
	@GetMapping("/shoppingcart/{userid}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable("userid") int userId) {
       ShoppingCart cart= service.getShopingCartByUserId(userId);
		return new ResponseEntity<ShoppingCart>(cart,HttpStatus.OK);
	
	}
	
	@PostMapping("/shoppingcart/post")
    public ResponseEntity<AppResponse> addShoppingCart(@RequestBody Map<String, String> request) {
		String isbn = request.get("isbn");
		int userId = Integer.parseInt(request.get("userid"));
		service.addShoppingCart(userId, isbn);
		AppResponse response = new AppResponse("POSTSUCCESS", "ShoppingCart added successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
	}

	@PutMapping("shoppingcart/update/isbn/{userId}")
	public ResponseEntity<AppResponse> updateIsbnByUserId(@PathVariable("userId") int userId , @RequestBody Map<String, String> request) {
		String newIsbn = request.get("isbn");
		service.updateIsbnByUserId(userId, newIsbn);
		AppResponse response = new AppResponse("UPDATESUCCESS", "ShoppingCart updated successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
	}
}