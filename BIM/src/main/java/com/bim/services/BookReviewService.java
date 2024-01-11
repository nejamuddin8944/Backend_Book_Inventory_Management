package com.bim.services;

import org.springframework.stereotype.Service;
import com.bim.entities.BookReview;

@Service
public interface BookReviewService {
	
	Boolean addBookReview(BookReview bookreview);
	BookReview getBookReviewbyId(String isbn, int reviewerId);
	Boolean updateRating(String isbn,int reviewerId, int rating);
	Boolean updateComments(String isbn,int reviewerId, String comments);

}
