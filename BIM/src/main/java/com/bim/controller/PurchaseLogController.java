package com.bim.controller;

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

import com.bim.entities.Book;
import com.bim.entities.BookReview;
import com.bim.entities.PurchaseLog;
import com.bim.repositories.PurchaseLogRepository;
import com.bim.response.AppResponse;
import com.bim.serviceImpl.PurchaseLogServiceImpl;

@RestController
@RequestMapping("/api")
public class PurchaseLogController {
	
	@Autowired
	PurchaseLogServiceImpl service;
	
	@GetMapping("/purchaselog/{userId}/{inventoryid}")
    public ResponseEntity<PurchaseLog> getPurchaseLogById(@PathVariable int userId, @PathVariable("inventoryid") int inventoryId) 
	{
		PurchaseLog purchaselogs = service.getPurchaseLogById(userId, inventoryId);
		return new ResponseEntity<PurchaseLog>(purchaselogs,HttpStatus.OK);
		
	}
	
	@PostMapping("/purchaselog/post")
    public ResponseEntity<AppResponse> addPurchaseLog(@RequestBody Map<String, Integer> request) {
		int userId = request.get("userid");
		int inventoryId = request.get("inventoryid");
		service.addPurchaseLog(userId,inventoryId);
		AppResponse response = new AppResponse("POSTSUCCESS", "Purchaselog added successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
	}

    @PutMapping("/purchaselog/update/inventoryid/{userId}/{inventoryid}")
    public ResponseEntity<AppResponse> updateInventoryIdById(@PathVariable int userId,@PathVariable("inventoryid") int inventoryId, @RequestBody Map<String, Integer> request){
    	int newInventoryId = request.get("inventoryid");
    	service.updateInventoryId(userId, newInventoryId);
    	AppResponse response = new AppResponse("UPDT-INVENTORYID-SUCCESS", "IventoryId of the inventory "+userId+" of the  "+inventoryId+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK) ;
    }
}

