package com.bim.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.Inventory;
import com.bim.entities.PurchaseLog;
import com.bim.entities.PurchaseLogId;
import com.bim.entities.ShoppingCart;
import com.bim.entities.ShoppingCartId;
import com.bim.entities.User;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateCartException;
import com.bim.exceptions.DuplicatePurchaseLogException;
import com.bim.exceptions.InventoryNotFoundException;
import com.bim.exceptions.ShoppingCartNotFoundException;
import com.bim.exceptions.UserNotFoundException;
import com.bim.repositories.BookRepository;
import com.bim.repositories.ShoppingCartRepository;
import com.bim.repositories.UserRepository;
import com.bim.response.AppResponse;
import com.bim.services.ShoppingCartServices;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartServices{

	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	@Autowired
	
	BookRepository bookRepo;
	@Autowired
	
	UserRepository userRepo;
	
	@Override
	public Boolean addShoppingCart(int userId, String isbn) {
		ShoppingCart cart=null;
		cart= shoppingCartRepo.findCartByUserId(userId);
		if (cart!=null) {
			throw new DuplicateCartException(new AppResponse("ADDFAIL", "Purchaselog already exists"));
		}
		
		Optional<User> optUser = userRepo.findById(userId);
		Optional<Book> optBook = bookRepo.findById(isbn);
		if(optUser.isEmpty())
			throw new UserNotFoundException(new AppResponse("GET-USER-FAIL", "User doesn't exist"));
		if(optBook.isEmpty())
			throw new BookNotFoundException(new AppResponse("GET-BOOK-FAIL", "Book doesn't exist"));
		ShoppingCart shoppingCart = new ShoppingCart(new ShoppingCartId(userId, isbn), optUser.get(), optBook.get());
	    shoppingCartRepo.save(shoppingCart);
		return true;
	}

	@Override
	public ShoppingCart getShopingCartByUserId(int userId) {
	ShoppingCart cart;
	cart = shoppingCartRepo.findCartByUserId(userId);
	if (cart==null) {
		throw new ShoppingCartNotFoundException(new AppResponse("GETFAIL", "Cart already exists"));
	}
	return cart;
	}

	@Override
	public Boolean updateIsbnByUserId(int userId,String isbn) {
		ShoppingCart cart;
		cart= shoppingCartRepo.findCartByUserId(userId);
		if (cart==null) {
			throw new ShoppingCartNotFoundException(new AppResponse("GET_FAIL", "Cart doesn't exist"));
		}
		
		Optional<User> optUser = userRepo.findById(userId);
		Optional<Book> optBook = bookRepo.findById(isbn);
		if(optUser.isEmpty())
			throw new UserNotFoundException(new AppResponse("GET-USER-FAIL", "User doesn't exist"));
		if(optBook.isEmpty())
			throw new BookNotFoundException(new AppResponse("GET-BOOK-FAIL", "Book doesn't exist"));
		cart.setBook(optBook.get());
		shoppingCartRepo.save(cart);
		return true;
	}

}
