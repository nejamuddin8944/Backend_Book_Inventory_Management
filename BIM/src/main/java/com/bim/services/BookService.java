package com.bim.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.Category;
import com.bim.entities.Publisher;

@Service
public interface BookService {
	
	 Boolean addBook(Book book);
	 Boolean updateBook(Book book);
	 Boolean deleteBook(String isbn);
	 Book getBookByIsbn(String isbn);
	 
	 List<Book> getAllBook();
	 List<Book> getByTittle(String tittle);
	 List<Book> getByCategory(int categoryID);
	 List<Book> getByPublisher(int publisherID);
	 
	 Boolean updateTitle(String isbn,String title);
	 Boolean updateDescription(String isbn,String description);
	 Boolean updateCategory(String isbn,Category category);
	 Boolean updateEdition(String isbn,String edition);
	 Boolean updatePublisher(String isbn,Publisher publisher);
	 
}
