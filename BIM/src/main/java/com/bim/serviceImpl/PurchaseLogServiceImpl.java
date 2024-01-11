package com.bim.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.Inventory;
import com.bim.entities.PurchaseLog;
import com.bim.entities.PurchaseLogId;
import com.bim.entities.User;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicatePurchaseLogException;
import com.bim.exceptions.InventoryNotFoundException;
import com.bim.exceptions.NullPurchaseLogListException;
import com.bim.exceptions.PublisherNotFoundException;
import com.bim.exceptions.PurchaseLogNotFoundException;
import com.bim.exceptions.UserNotFoundException;
import com.bim.repositories.InventoryRepository;
import com.bim.repositories.PurchaseLogRepository;
import com.bim.repositories.UserRepository;
import com.bim.response.AppResponse;
import com.bim.services.PurchaseLogService;

@Service
public class PurchaseLogServiceImpl implements PurchaseLogService{
	
	@Autowired
	PurchaseLogRepository purchaseLogRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	InventoryRepository inventoryRepo;

	@Override
	public Boolean addPurchaseLog(int userId, int inventoryId) {
		Optional<PurchaseLog> opt = purchaseLogRepo.findById(new PurchaseLogId(userId, inventoryId));
		if (opt.isPresent()) {
			throw new DuplicatePurchaseLogException(new AppResponse("ADDFAIL", "Purchaselog already exists"));
		}
		
		Optional<User> optUser = userRepo.findById(userId);
		Optional<Inventory> optInventory = inventoryRepo.findById(inventoryId);
		if(optUser.isEmpty())
			throw new UserNotFoundException(new AppResponse("GET-USER-FAIL", "User doesn't exist"));
		if(optInventory.isEmpty())
			throw new InventoryNotFoundException(new AppResponse("GET-INVENTORY-FAIL", "Inventory doesn't exist"));
		PurchaseLog purchaselog = new PurchaseLog(new PurchaseLogId(userId, inventoryId), optUser.get(), optInventory.get());
	    purchaseLogRepo.save(purchaselog);
		return true;
 
	}

	@Override
	public PurchaseLog getPurchaseLogById(int userId, int inventoryId) {
		List<PurchaseLog> purchaseloglist = purchaseLogRepo.findAllByUserId(userId);
		if (purchaseloglist == null || purchaseloglist.isEmpty()) {
			throw new NullPurchaseLogListException(new AppResponse("GET_ALL_BY_USER_ID_FAIL", "PurchaseLog doesn't exist"));
		}
		for(PurchaseLog pl:purchaseloglist) {
			if(pl.getId().getInventoryId()==inventoryId) {
				return pl;
			}
		}
		throw new InventoryNotFoundException(new AppResponse("GET_PURCHASELOGID_FAIL", "inventory doesn't exist"));

	}
	
	@Override
	public Boolean updateInventoryId(int userId,int inventoryId) {
		List<PurchaseLog> purchaseloglist = purchaseLogRepo.findAllByUserId(userId);
		if (purchaseloglist == null || purchaseloglist.isEmpty()) {
			throw new PurchaseLogNotFoundException(new AppResponse("UPDT_USERID_FAIL", "PurchaseLog doesn't exist"));
		}
		Optional<Inventory> optInventory = inventoryRepo.findById(inventoryId);
		if(optInventory.isEmpty())
			throw new InventoryNotFoundException(new AppResponse("UPDT_INVENTORYID_FAIL", "Purchaselog does not exists"));
		for(PurchaseLog pl:purchaseloglist) {
			if(pl.getId().getInventoryId()==inventoryId) {
			purchaseLogRepo.save(pl);
			}
		}
		return true;	
  }
}
