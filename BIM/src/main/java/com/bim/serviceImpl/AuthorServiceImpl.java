package com.bim.serviceImpl;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.bim.entities.Author;
import com.bim.entities.Book;
import com.bim.exceptions.AuthorNotFoundException;
import com.bim.exceptions.DuplicateAuthorException;
import com.bim.exceptions.NullAuthorListException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.repositories.AuthorRepository;
import com.bim.repositories.BookAuthorRepository;
import com.bim.response.AppResponse;
import com.bim.services.AuthorService;
 
@Service
public class AuthorServiceImpl implements AuthorService {
 
	
	@Autowired
	AuthorRepository authorRepo;
	
	@Autowired
	BookAuthorRepository bookAuthorRepo;
 
	@Override
	public Boolean addAuthor(Author author) {
		Optional<Author> opt = authorRepo.findById(author.getId());
		if (opt.isPresent()) {
			throw new DuplicateAuthorException(new AppResponse("ADD_AUTHOR_FAIL", "Author already exists"));
		}
		authorRepo.save(author);
		return true;
 
	}
	
 
	@Override
	public Boolean updateFirstName(int authorId, String firstName) {
		Optional<Author> opt = authorRepo.findById(authorId);
		if (opt.isPresent()) {
			Author author = opt.get();
			author.setFirstName(firstName);
			authorRepo.save(author);
			return true;
		}
		throw new AuthorNotFoundException(new AppResponse("UPDATEFAIL", "Author already exists"));
 
	}
 
	@Override
	public Boolean updateLastName(int authorId, String lastName) {
		Optional<Author> opt = authorRepo.findById(authorId);
		if (opt.isPresent()) {
			Author author = opt.get();
			author.setLastName(lastName);
			authorRepo.save(author);
			return true;
		}
		throw new DuplicateAuthorException(new AppResponse("UPDATEFAIL", "Author already exists"));
 
	}
 
	@Override
	public List<Book> getBooksByAuthorId(int authorId) {
		List<Book> bookListByAuthorId = bookAuthorRepo.findAllBooksByAuthor(authorId);
		if(bookListByAuthorId==null)
			throw new NullBookListExceptione(new AppResponse("GET-ALL-BOOKS-BY-AUTHOR-FAIL", "No Books is found for this author "));
		return bookListByAuthorId;
	}
 
	
	@Override
	public Author getAuthorByauthorId(int authorId) {
		Optional<Author> opt = authorRepo.findById(authorId);
		if (opt.isPresent()) {
 
			return opt.get();
		}
		throw new AuthorNotFoundException(new AppResponse("GETFAIL", "Author doesn't exist"));
	}
	
 
	@Override
	public Author getByFirstName(String firstName) {
		Author author = authorRepo.findByFirstname(firstName);
		if (author == null) {
			throw new AuthorNotFoundException(new AppResponse("GET_FAIL_BY_FIRST_NAME", "Author with " + firstName + " doesn't exist"));
		}
		return author;
 
		
	}
 
	@Override
	public Author getByLastName(String lastName) {
	
		Author author = authorRepo.findByLastname(lastName);
		if (author == null) {
 
			throw new NullAuthorListException(new AppResponse("GET_FAIL_BY_LAST_NAME", "Author with " + lastName + " doesn't exist"));
		}
		return author;
 
	}
	
	@Override
	public List<Author> getAllAuthor() {
		List<Author> authors = authorRepo.findAll();
		if(authors.isEmpty()|| authors==null)
			throw new NullAuthorListException(new AppResponse("GET_FAIL", "Author with  doesn't exist"));
		return authors;
	}
	
	@Override
	public Boolean deleteAuthor(int authorId) {
		Optional<Author> opt = authorRepo.findById(authorId);
		if(opt.isEmpty())
			throw new AuthorNotFoundException(new AppResponse("DLTFAIL", "Athor doesn't exist"));
		authorRepo.deleteById(authorId);
		return true;
	}


	@Override
	public Boolean updateName(int authorId, String firstName, String lastName) {
		Optional<Author> opt = authorRepo.findById(authorId);
		if (opt.isPresent()) {
			Author author = opt.get();
			author.setFirstName(firstName);
			author.setLastName(lastName);
			authorRepo.save(author);
			return true;
		}
		throw new AuthorNotFoundException(new AppResponse("UPDATEFAIL", "Author doesn't exists"));
 
	}
}