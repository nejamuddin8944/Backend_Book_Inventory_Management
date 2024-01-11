package com.bim.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.BookCondition;
import com.bim.exceptions.BookConditionNotFoundException;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookConditionException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.repositories.BookConditionRepository;
import com.bim.response.AppResponse;
import com.bim.services.AuthorService;
import com.bim.services.BookConditionService;

@Service
public class BookConditionServiceImpl implements BookConditionService{
	@Autowired
	BookConditionRepository bookConditionRepo;

	@Override
	public Boolean addBookCondition(BookCondition bookCondition) {
		Optional<BookCondition> opt = bookConditionRepo.findById(bookCondition.getRanks());
		if (opt.isPresent()) {
			throw new DuplicateBookConditionException(new AppResponse("ADDFAIL", "BookCondition already exits"));
		}
		bookConditionRepo.save(bookCondition);
		return true;
	}

	@Override
	public BookCondition getBookConditionByRanks(int ranks)  {
			Optional<BookCondition> opt = bookConditionRepo.findById(ranks);
			if (opt.isPresent()) {
				return opt.get();
			}
			  throw new BookConditionNotFoundException(new AppResponse("GETFAIL", "Bookcondition doesn't exist"));
		
	}

	@Override
	public Boolean updateDescription(int ranks, String description) {
		Optional<BookCondition> opt = bookConditionRepo.findById(ranks);
		if (opt.isPresent()) {
            BookCondition bookCondition = opt.get();
			bookConditionRepo.save(bookCondition);
			return true;
		}
		throw new BookConditionNotFoundException(new AppResponse("UPDT_DESCRIPTION_FAIL", "Bookcondition doesn't exist"));
	}

	@Override
	public Boolean updateFullDescription(int ranks, String fullDescription) {
		Optional<BookCondition> opt = bookConditionRepo.findById(ranks);
		if (opt.isPresent()) {
            BookCondition bookCondition = opt.get();
			bookConditionRepo.save(bookCondition);
			return true;
		}
		throw new BookConditionNotFoundException(new AppResponse("UPDT_FULLDESCRIPTION_FAIL", "Bookcondition doesn't exist"));
	}
	


	@Override
	public Boolean updatePrice(int ranks, double price) {
		Optional<BookCondition> opt = bookConditionRepo.findById(ranks);
		if (opt.isPresent()) {
			BookCondition bookCondition = opt.get();
			bookCondition.setPrice(price);
			bookConditionRepo.save(bookCondition);
			return true;
		}
		throw new BookConditionNotFoundException(new AppResponse("UPDT_ PRICE_FAIL", "Bookcondition doesn't exist"));
		
	}

	

}
