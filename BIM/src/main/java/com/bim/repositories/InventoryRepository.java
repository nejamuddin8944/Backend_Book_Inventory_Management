package com.bim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bim.entities.Book;
import com.bim.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
