package com.bim.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.BookReview;
import com.bim.entities.BookReviewId;
import com.bim.entities.Reviewer;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.BookReviewNotFoundException;
import com.bim.exceptions.DuplicateBookReviewException;
import com.bim.exceptions.NullBookReviewListException;
import com.bim.exceptions.ReviewerNotFoundException;
import com.bim.repositories.BookRepository;
import com.bim.repositories.BookReviewRepository;
import com.bim.repositories.ReviewerRepository;
import com.bim.response.AppResponse;
import com.bim.services.BookReviewService;

@Service
public class BookReviewServiceImpl implements BookReviewService {

	@Autowired
	BookReviewRepository bookreviewRepo;
	
	@Autowired
	ReviewerRepository reviewerRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	

	@Override
	public Boolean addBookReview(BookReview bookreview) {
		Optional<BookReview> opt = bookreviewRepo.findById(bookreview.getId());
		if (opt.isPresent()) {
			throw new DuplicateBookReviewException(new AppResponse("ADDFAIL", "BookReview already exists"));
		}
		String isbn = bookreview.getId().getIsbn();
		int reviewerId = bookreview.getId().getReviewerId();
		
		Optional<Book> optBook = bookRepo.findById(isbn);
		Optional<Reviewer> optReviewer = reviewerRepo.findById(reviewerId);
		if(optBook.isEmpty())
			throw new BookNotFoundException(new AppResponse("GET-BOOK-FAIL", "Book doesn't exist"));
		bookreviewRepo.save(bookreview);
		if(optReviewer.isEmpty())
			throw new ReviewerNotFoundException(new AppResponse("GET-REVIEWER-FAIL", "Reviewer doesn't exist"));
		
	    bookreviewRepo.save(bookreview);
		return true;

	}

	@Override
	public BookReview getBookReviewbyId(String isbn, int reviewerId) {
		List<BookReview> bookReviewList = bookreviewRepo.findAllByIsbn(isbn);
		if (bookReviewList == null || bookReviewList.isEmpty()) {
			throw new NullBookReviewListException(new AppResponse("GET_ALL_BY_ISBN_FAIL", "BookReview doesn't exist"));
		}
		for(BookReview br:bookReviewList) {
			if(br.getId().getReviewerId()==reviewerId) {
				return br;
			}
		}
		throw new ReviewerNotFoundException(new AppResponse("GET_BOOKREVIEWBYID_FAIL", "reviewer doesn't exist"));
	    
		 
	}

	@Override
	public Boolean updateRating(String isbn,int reviewerId, int rating) {
		List<BookReview> bookreviewList = bookreviewRepo.findAllByIsbn(isbn);
		if (bookreviewList == null || bookreviewList.isEmpty()) {
			throw new BookReviewNotFoundException(new AppResponse("UPDT_RATING_FAIL", "BookReview doesn't exist"));
		}
		Optional<Reviewer> optReviewer = reviewerRepo.findById(reviewerId);
		if(optReviewer.isEmpty())
			throw new ReviewerNotFoundException(null);
		for(BookReview br:bookreviewList) {
			if(br.getId().getReviewerId()==reviewerId) {
				br.setRating(rating);
				bookreviewRepo.save(br);
			}
		}
		return true;
		
	}

	@Override
	public Boolean updateComments(String isbn,int reviewerId, String comments) {
		List<BookReview> bookreviewList = bookreviewRepo.findAllByIsbn(isbn);
		if (bookreviewList == null || bookreviewList.isEmpty()) {
			throw new BookReviewNotFoundException(new AppResponse("UPDT_COMMENTS_FAIL", "BookReview doesn't exist"));
		}
		Optional<Reviewer> optReviewer = reviewerRepo.findById(reviewerId);
		if(optReviewer.isEmpty())
			throw new ReviewerNotFoundException(null);
		for(BookReview br:bookreviewList) {
			if(br.getId().getReviewerId()==reviewerId) {
				br.setComments(comments);
				bookreviewRepo.save(br);
			}
		}
		return true;
		}
}
