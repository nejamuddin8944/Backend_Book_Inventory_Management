package com.bim.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.BookCondition;
import com.bim.entities.Inventory;
import com.bim.exceptions.BookConditionNotFoundException;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookConditionException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.DuplicateInventoryException;
import com.bim.exceptions.InventoryNotFoundException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.repositories.InventoryRepository;
import com.bim.response.AppResponse;
import com.bim.services.InventoryService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Service
public class InventoryServiceImpl implements InventoryService{
	@Autowired
	InventoryRepository inventoryRepo;

	@Override
	public Boolean addInventory(Inventory inventory) {
		Optional<Inventory> opt = inventoryRepo.findById(inventory.getInventoryId());
		if (opt.isPresent()) {

			throw new DuplicateInventoryException(new AppResponse("ADDFAIL", "Inventory already exits"));
		}
		inventoryRepo.save(inventory);
		return true;
	
	}


	@Override
	public Boolean updatePurchased(int inventoryId, int purchased) {
		Optional<Inventory> opt = inventoryRepo.findById(inventoryId);
		if (opt.isPresent()) {

			Inventory inventory = opt.get();
			inventory.setPurchased(purchased); 
			inventoryRepo.save(inventory);
			return true;
		}
		throw new InventoryNotFoundException(new AppResponse("UPDT_PURCHASED_FAIL", "Inventory doesn't exist"));
		
	}

	@Override
	public Inventory getInventoryByInventoryId(int inventoryId) {
		Optional<Inventory> opt = inventoryRepo.findById(inventoryId);
		if (opt.isPresent()) {

			return opt.get();
		}
		throw new InventoryNotFoundException(new AppResponse("GETFAIL", "Inventory doesn't exist"));
	}


	
}
