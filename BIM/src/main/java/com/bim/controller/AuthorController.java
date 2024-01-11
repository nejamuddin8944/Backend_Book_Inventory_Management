package com.bim.controller;
 
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.bim.entities.Author;
import com.bim.entities.Book;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.response.AppResponse;
import com.bim.serviceImpl.AuthorServiceImpl;
 
@RestController
@RequestMapping("/api")
public class AuthorController {
 
	@Autowired
	AuthorServiceImpl service;
 
	@GetMapping(value = "/author/{authorId}")
	public ResponseEntity<Author> getAuthorById(@PathVariable int authorId) {
		Author author = service.getAuthorByauthorId(authorId);
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}
 
	@PostMapping(value = "/author/post")
	public ResponseEntity<AppResponse> addAuthor(@RequestBody Author author) {
		service.addAuthor(author);
		AppResponse response = new AppResponse("POSTSUCCESS", "Author added successfully");
		return new ResponseEntity<AppResponse>(response, HttpStatus.CREATED);
	}
 
	@PutMapping(value = "/update/firstname/{authorId}")
	public ResponseEntity<AppResponse> updateFirstNameById(@PathVariable int authorId,
			@RequestBody Map<String, String> request) {
		String newFirstName = request.get("firstName");
		service.updateFirstName(authorId, newFirstName);
		AppResponse response = new AppResponse("UPDT-FIRSTNAME-SUCCESS",
				"Firstname of the author" + authorId + " successfully updated");
		return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
	}
 
	@PutMapping(value = "/update/lastname/{authorId}")
	public ResponseEntity<AppResponse> updateLastNameById(@PathVariable int authorId,
			@RequestBody Map<String, String> request) {
		String newLastName = request.get("lastName");
		service.updateLastName(authorId, newLastName);
		AppResponse response = new AppResponse("UPDT-LastNAME-SUCCESS",
				"Lastname of the author" + authorId + " successfully updated");
		return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
	}
 
	@GetMapping(value = "/author/firstname/{firstname}")
	public ResponseEntity<Author> getAuthorByFirstName(@PathVariable("firstname") String firstName) {
		Author author;
		author = service.getByFirstName(firstName);
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}
 
	@GetMapping(value = "/author/lastname/{lastname}")
	public ResponseEntity<Author> getAuthorByLastName(@PathVariable("lastname") String lastName) {
		Author author;
		author = service.getByLastName(lastName);
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}
 
	@GetMapping("/author/books/{authorId}")
	public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable int authorId) {
		List<Book> bookListByAuthorId = service.getBooksByAuthorId(authorId);
 
		if (bookListByAuthorId.isEmpty()) {
			throw new NullBookListExceptione(new AppResponse("GETALLFAIL", "Book list is empty"));
		}
		return new ResponseEntity<List<Book>>(bookListByAuthorId, HttpStatus.OK);
	}
	
	@GetMapping("/authors")
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> authors = service.getAllAuthor();

		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{authorId}")
	public ResponseEntity<AppResponse> deleteAuthorById(@PathVariable int authorId) {
		service.deleteAuthor(authorId);
		 AppResponse response = new AppResponse("DELETE-SUCCESS", "Author successfully deleted");
		return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{authorId}")
	public ResponseEntity<AppResponse> updateName(@PathVariable int authorId,
			@RequestBody Map<String, String> request) {
		String newFirstName = request.get("firstName");
		String newLastName = request.get("lastName");
		service.updateName(authorId, newFirstName, newLastName);
		AppResponse response = new AppResponse("UPDT-NAME-SUCCESS","successfully updated");
		return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
	}
 
}
 