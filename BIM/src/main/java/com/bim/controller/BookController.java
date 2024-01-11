package com.bim.controller;

import java.util.List;
import java.util.Map;

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
import com.bim.entities.Category;
import com.bim.entities.Publisher;
import com.bim.response.AppResponse;
import com.bim.serviceImpl.BookServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class BookController {
	
	@Autowired
	BookServiceImpl service;
	
	@PostMapping(value = "/book/post")
	public ResponseEntity<AppResponse> addBook(@RequestBody Book book) {
		service.addBook(book);
		AppResponse response = new AppResponse("POSTSUCCESS", "Book added successfully");
		return new ResponseEntity<AppResponse>(response,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> bookList = service.getAllBook();
		return new ResponseEntity<List<Book>>(bookList,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/book/{isbn}")
	public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
		Book book = service.getBookByIsbn(isbn);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@GetMapping(value = "/book/title/{title}")
	public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title){
		List<Book> bookListByTitle= service.getByTittle(title);
		return new ResponseEntity<List<Book>>(bookListByTitle,HttpStatus.OK);
	}
	
	@GetMapping(value = "/book/category/{category}")
	public ResponseEntity<List<Book>> getBookByCategory(@PathVariable int category){
		List<Book> bookListByCategory = service.getByCategory(category);
		return new ResponseEntity<List<Book>>(bookListByCategory,HttpStatus.OK);
	}
	
	@GetMapping(value = "/book/publisher/{publisherId}")
	public ResponseEntity<List<Book>>getBookByPublisher(@PathVariable int publisherId){
		List<Book> bookListByPublisher = service.getByPublisher(publisherId);
		return new ResponseEntity<List<Book>>(bookListByPublisher,HttpStatus.OK);
	}
	
	@PutMapping(value = "/book/update/title/{isbn}")
	public ResponseEntity<AppResponse> updateTitleByIsbn(@PathVariable String isbn ,@RequestBody Map<String, String> request){
		String newTitle = request.get("title");
		service.updateTitle(isbn,newTitle);
		AppResponse response = new AppResponse("UPDT-TITLE-SUCCESS", "Tittle of the book"+isbn+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping(value = "/book/update/description/{isbn}")
	public ResponseEntity<AppResponse> updateDescriptionByIsbn(@PathVariable String isbn ,@RequestBody Map<String, String> request){
		String newDecription = request.get("description");
		service.updateDescription(isbn, newDecription);
		AppResponse response = new AppResponse("UPDT-DESCRIPTION-SUCCESS", "Description of the book"+isbn+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping(value = "/book/update/edition/{isbn}")
	public ResponseEntity<AppResponse> updateEditionByIsbn(@PathVariable String isbn ,@RequestBody Map<String, String> request){
		String newEdition = request.get("edition");
		service.updateEdition(isbn, newEdition);
		AppResponse response = new AppResponse("UPDT-EDITION-SUCCESS", "Edition of the book"+isbn+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping(value = "/book/update/category/{isbn}")
	public ResponseEntity<AppResponse> updateCategoryByIsbn(@PathVariable String isbn ,@RequestBody Map<String, Category> request){
		Category newCategory = request.get("category");
		service.updateCategory(isbn, newCategory);
		AppResponse response = new AppResponse("UPDT-CATEGORY-SUCCESS", "Category of the book"+isbn+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping(value = "/book/update/publisher/{isbn}")
	public ResponseEntity<AppResponse> updatePublisherByIsbn(@PathVariable String isbn ,@RequestBody Map<String, Publisher> request){
		Publisher newPublisher = request.get("publisher");
		service.updatePublisher(isbn, newPublisher);
		AppResponse response = new AppResponse("UPDT-PUBLISHER-SUCCESS", "Publisher of the book"+isbn+" successfully updated");
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	
	
	
}
