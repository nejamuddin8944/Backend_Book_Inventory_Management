package com.bim.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.Category;
import com.bim.entities.Publisher;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.repositories.BookRepository;
import com.bim.response.AppResponse;
import com.bim.services.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepo;

	@Override
	public Boolean addBook(Book book) {
		Optional<Book> opt = bookRepo.findById(book.getIsbn());
		if (opt.isPresent()) {

			throw new DuplicateBookException(new AppResponse("ADDFAIL", "Book already exits"));
		}
		bookRepo.save(book);
		return true;
	}

	@Override
	public Boolean updateBook(Book book) {
		Optional<Book> opt = bookRepo.findById(book.getIsbn());
		if (opt.isPresent()) {

			bookRepo.save(book);
			return true;
		}
		throw new BookNotFoundException(new AppResponse("UPDTFAIL", "Book doesn't exist"));
	}

	@Override
	public Boolean deleteBook(String isbn) {
		Optional<Book> opt = bookRepo.findById(isbn);
		if (opt.isPresent()) {

			bookRepo.deleteById(isbn);
			return true;
		}
		throw new BookNotFoundException(new AppResponse("DLTFAIL", "Book doesn't exist"));
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		Optional<Book> opt = bookRepo.findById(isbn);
		if (opt.isPresent()) {

			return opt.get();
		}
		throw new BookNotFoundException(new AppResponse("GETFAIL", "Book doesn't exist"));
	}

	@Override
	public List<Book> getByTittle(String title) {
		List<Book> bookListByTitle = bookRepo.findByTitle(title);
		if (bookListByTitle == null || bookListByTitle.isEmpty()) {

			throw new NullBookListExceptione(new AppResponse("GET_FAIL_BY_TITTLE", "Book with " + title + " doesn't exist"));
		}
		return bookListByTitle;

	}

	@Override
	public List<Book> getAllBook() {
		List<Book> bookList = bookRepo.findAll();
		if (bookList == null || bookList.isEmpty()) {

			throw new NullBookListExceptione(new AppResponse("GETALLFAIL", "Book list is empty"));
		}
		return bookList;
	}

	@Override
	public List<Book> getByCategory(int categoryID) {
		List<Book> bookListByCategory = bookRepo.findByCategory(categoryID);
		if (bookListByCategory == null || bookListByCategory.isEmpty())
			throw new NullBookListExceptione(
					new AppResponse("GET_BY_CATEGORY_FAIL", "Book with " + categoryID + " doesn't exist"));
		return bookListByCategory;
	}

	@Override
	public List<Book> getByPublisher(int publisherID) {
		List<Book> bookListByPublisher = bookRepo.findByPublisher(publisherID);
		if (bookListByPublisher == null || bookListByPublisher.isEmpty())
			throw new NullBookListExceptione(
					new AppResponse("GET_BY_PUBLISHER_FAIL", "Book with " + publisherID + " doesn't exist"));
		return bookListByPublisher;
	}

	@Override
	public Boolean updateTitle(String isbn, String title) {
		Optional<Book> opt = bookRepo.findById(isbn);
		if (opt.isPresent()) {

			Book book = opt.get();
			book.setTitle(title); // opt.get will return the book object and then set the title
			bookRepo.save(book);
			return true;
		}
		throw new BookNotFoundException(new AppResponse("UPDT_TITLE_FAIL", "Book doesn't exist"));
	}

	@Override
	public Boolean updateDescription(String isbn, String description) {
		Optional<Book> opt = bookRepo.findById(isbn);
		if (opt.isPresent()) {

			Book book = opt.get();
			book.setDescription(description); // opt.get will return the book object and then set the Description
			bookRepo.save(book);
			return true;
		}
		throw new BookNotFoundException(new AppResponse("UPDT_DESCRIPTION_FAIL", "Book doesn't exist"));
	}

	@Override
	public Boolean updateEdition(String isbn, String edition) {
		Optional<Book> opt = bookRepo.findById(isbn);
		if (opt.isPresent()) {

			Book book = opt.get();
			book.setEdition(edition); // opt.get will return the book object and then set the Edition
			bookRepo.save(book);
			return true;
		}
		throw new BookNotFoundException(new AppResponse("UPDT_EDITION_FAIL", "Book doesn't exist"));
	}

	@Override
	public Boolean updateCategory(String isbn, Category category) {
		Optional<Book> opt = bookRepo.findById(isbn);
		if (opt.isPresent()) {

			Book book = opt.get();
//			book.getCategory().setCatDescription(category.getCatDescription()); ////this line setting category attribute(categoryDescription) in category table 
			book.setCategory(category);// this line add primary key of Category table(PublisherID)
			bookRepo.save(book);
			return true;
		}
		throw new BookNotFoundException(new AppResponse("UPDT_CATEGORY_FAIL", "Book doesn't exist"));
	}

	@Override
	public Boolean updatePublisher(String isbn, Publisher publisher) {
		Optional<Book> opt = bookRepo.findById(isbn);
		if (opt.isPresent()) {

			Book book = opt.get();
//			book.getPublisher().setCity(publisher.getCity());  //this line setting publisher attribute(City) in publisher table 
//			book.getPublisher().setName(publisher.getName());  //this line setting publisher attribute(Name) in publisher table
//			book.getPublisher().setState(publisher.getState());  //this line setting publisher attribute(StateCode) in publisher table
			book.setPublisher(publisher); // this line add primary key of publisher table(PublisherID)
			bookRepo.save(book);
			return true;
		}
		throw new BookNotFoundException(new AppResponse("UPDT_PUBLISHER_FAIL", "Book doesn't exist"));
	}

}
