package com.bim.services;

import com.bim.entities.PurchaseLog;
import com.bim.entities.ShoppingCart;

public interface ShoppingCartServices {

	Boolean addShoppingCart(int userId, String isbn);

	Boolean updateIsbnByUserId(int userId,String isbn);
	
	ShoppingCart getShopingCartByUserId(int userId);
	
}
