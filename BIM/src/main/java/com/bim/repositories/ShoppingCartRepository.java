package com.bim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.bim.entities.ShoppingCart;
import com.bim.entities.ShoppingCartId;
@Service
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartId> {
	
	
	@Query("SELECT s FROM ShoppingCart s where s.user.userId=:userId")
	ShoppingCart findCartByUserId(@Param("userId") int userId);
 
}
