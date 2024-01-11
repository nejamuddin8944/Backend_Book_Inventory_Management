package com.bim.services;

import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.BookCondition;

@Service
public interface BookConditionService {
	
	 Boolean addBookCondition(BookCondition bookCondition);
	 
	 BookCondition getBookConditionByRanks(int ranks);
	 
	 Boolean updateDescription(int ranks,String description);
	 
	 Boolean updateFullDescription(int rank,String fullDescription);
	
	 Boolean updatePrice(int ranks,double price);

}
