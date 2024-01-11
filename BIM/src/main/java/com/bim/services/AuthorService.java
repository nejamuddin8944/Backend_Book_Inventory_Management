package com.bim.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bim.entities.Author;
import com.bim.entities.Book;

@Service
public interface AuthorService {
	Boolean addAuthor(Author author);

	Author getAuthorByauthorId(int authorId);

	Author getByFirstName(String firstName);

	Author getByLastName(String lastName);

	Boolean updateFirstName(int authorId, String firstName);

	Boolean updateLastName(int authorId, String lastName);

	Boolean updateName(int authorId, String firstName, String lastName);

	Boolean deleteAuthor(int authorId);

	List<Book> getBooksByAuthorId(int authorId);
	
	List<Author> getAllAuthor();

}
