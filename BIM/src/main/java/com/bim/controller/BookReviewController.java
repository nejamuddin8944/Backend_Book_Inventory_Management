package com.bim.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.entities.Book;
import com.bim.entities.BookReview;
import com.bim.entities.BookReviewId;
import com.bim.entities.Reviewer;
import com.bim.repositories.BookRepository;
import com.bim.repositories.BookReviewRepository;
import com.bim.repositories.ReviewerRepository;
import com.bim.response.AppResponse;
import com.bim.serviceImpl.BookReviewServiceImpl;

@RestController
@RequestMapping("/api")
public class BookReviewController {
	
	@Autowired
	BookReviewServiceImpl service;
	
	
	
	@GetMapping("/bookreviewsbybook/{isbn}/{reviewerId}")
    public ResponseEntity<BookReview> getBookReviewById(@PathVariable String isbn,@PathVariable int reviewerId) {
		BookReview bookReview = service.getBookReviewbyId(isbn, reviewerId);
		return new ResponseEntity<BookReview>(bookReview,HttpStatus.OK);
	}

	@PostMapping("/bookreview/post")
    public ResponseEntity<AppResponse> addBookReview(@RequestBody BookReview bookreview) {
		service.addBookReview(bookreview);
		AppResponse response = new AppResponse("POSTSUCCESS", "BookReview added successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
	}
	
	
    @PutMapping("/bookreview/update/rating/{isbn}/{reviewerId}")
    public ResponseEntity<AppResponse> updateRatingbyId(@PathVariable String isbn,@PathVariable int reviewerId, @RequestBody Map<String, Integer> request){
    	int newRating = request.get("rating");
    	service.updateRating(isbn, reviewerId, newRating);
    	AppResponse response = new AppResponse("UPDT-RATING-SUCCESS", "Rating of the book "+isbn+" of the the reviewer of id "+reviewerId+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK) ;
    	
    }
    

    @PutMapping("/bookreview/update/comments/{isbn}/{reviewerId}")
    public ResponseEntity<AppResponse> updateCommentsbyId(@PathVariable String isbn,@PathVariable int reviewerId, @RequestBody Map<String, String> request){
    	String newComments = request.get("comments");
    	service.updateComments(isbn, reviewerId, newComments);
    	AppResponse response = new AppResponse("UPDT-COMMENTS-SUCCESS", "Rating of the bookreview"+isbn+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK) ;

}
}
