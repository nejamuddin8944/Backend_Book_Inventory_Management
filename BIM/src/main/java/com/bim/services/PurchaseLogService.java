package com.bim.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.entities.PurchaseLog;
import com.bim.entities.PurchaseLogId;

@Service
public interface PurchaseLogService {
	
	Boolean addPurchaseLog(int userId, int inventoryId);
	
	PurchaseLog getPurchaseLogById(int userId, int inventoryId);
	
	Boolean updateInventoryId(int userId,int inventoryId);
	
}
