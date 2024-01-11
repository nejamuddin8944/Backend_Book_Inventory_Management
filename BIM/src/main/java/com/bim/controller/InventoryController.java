package com.bim.controller;

import java.util.Map;
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
import com.bim.entities.Inventory;
import com.bim.response.AppResponse;
import com.bim.serviceImpl.InventoryServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class InventoryController {
	
	@Autowired
	InventoryServiceImpl service;
	
	@PostMapping(value = "/inventory/post")
	public ResponseEntity<AppResponse> addInventory(@RequestBody Inventory inventory) {
		service.addInventory(inventory);
		AppResponse response = new AppResponse("POSTSUCCESS", "Book inventory added successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
	}


	@GetMapping(value = "/inventory/{inventoryId}")
    public ResponseEntity<Inventory> getInventoryByInventoryId(@PathVariable int inventoryId) {   
		Inventory inventory = service.getInventoryByInventoryId(inventoryId);
		return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);	
	}
		
	@PutMapping(value = "/inventory/update/purchased/{inventoryId}")
	public ResponseEntity<AppResponse> updatePurchasedByInventoryId(@PathVariable int inventoryId ,@RequestBody Map<String, Integer> request){
		int newPurchased = request.get("purchased");
		service.updatePurchased(inventoryId, newPurchased);
		AppResponse response = new AppResponse("UPDT-PURCHASED-SUCCESS", "Purchased with Id"+inventoryId+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}

}
