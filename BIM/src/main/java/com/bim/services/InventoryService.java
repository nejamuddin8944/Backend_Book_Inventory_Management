package com.bim.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.Inventory;

@Service
public interface InventoryService {
	
	Boolean addInventory(Inventory inventory);
	
	Inventory getInventoryByInventoryId(int inventoryId);
	
	Boolean updatePurchased(int inventoryId,int purchased);

}
