//package com.bim;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Service;
//
//import com.bim.entities.Author;
//import com.bim.entities.Book;
//import com.bim.entities.BookCondition;
//import com.bim.entities.Category;
//import com.bim.entities.PermRole;
//import com.bim.entities.Publisher;
//
//import com.bim.entities.Reviewer;
//import com.bim.entities.State;
//import com.bim.entities.User;
//import com.bim.repositories.AuthorRepository;
//import com.bim.repositories.BookConditionRepository;
//import com.bim.repositories.BookRepository;
//import com.bim.repositories.CategoryRepository;
//import com.bim.repositories.PermRoleRepository;
//import com.bim.repositories.PublisherRepository;
//import com.bim.repositories.ReviewerRepository;
//import com.bim.repositories.StateRepositories;
//import com.bim.repositories.UserRepository;
//
//@Service
//public class DbInit implements CommandLineRunner {
//
//	@Autowired
//	BookRepository bookRepo;
//	@Autowired
//	CategoryRepository categoryRepo;
//	@Autowired
//	PublisherRepository publisherRepo;
//	@Autowired
//	StateRepositories stateRepo;
//	@Autowired
//	ReviewerRepository reviewerRepo;
//	@Autowired
//	PermRoleRepository permRoleRepo;
//	@Autowired
//	AuthorRepository authorRepo;
//	@Autowired
//	UserRepository userRepo;
//	@Autowired
//	BookConditionRepository bookConditionRepo;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		State state1 = new State("WB", "West Bengal");
//		State state2 = new State("TS", "Telangana State");
//
//		stateRepo.save(state1);
//		stateRepo.save(state2);
//
//		Category category1 = new Category(10, "catDesc1");
//		Category category2 = new Category(20, "catDesc2");
//
//		categoryRepo.save(category1);
//		categoryRepo.save(category2);
//
//		Publisher publisher1 = new Publisher(100, "pub1", "city1", state1);
//		Publisher publisher2 = new Publisher(200, "pub2", "city2", state2);
//
//		publisherRepo.save(publisher1);
//		publisherRepo.save(publisher2);
//
//		Book book1 = new Book("isbn1", "ttl1", "decs1", "edit1", category1, publisher1);
//		Book book2 = new Book("isbn2", "ttl1", "decs2", "edit2", category2, publisher1);
//		Book book3 = new Book("isbn3", "ttl3", "decs3", "edit3", category1, publisher2);
//
//		bookRepo.save(book1);
//		bookRepo.save(book2);
//		bookRepo.save(book3);
//
//		Reviewer reviewer1 = new Reviewer(1, "rev1", "emp1");
//		Reviewer reviewer2 = new Reviewer(2, "rev2", "emp2");
//
//		reviewerRepo.save(reviewer1);
//		reviewerRepo.save(reviewer2);
//
//		PermRole permrole1 = new PermRole(100, "admin");
//		PermRole permrole2 = new PermRole(200, "storeOwner");
//		PermRole permrole3 = new PermRole(300, "guest");
//		PermRole permrole4 = new PermRole(400, "registeredUser");
//
//		permRoleRepo.save(permrole1);
//		permRoleRepo.save(permrole2);
//		permRoleRepo.save(permrole3);
//		permRoleRepo.save(permrole4);
//
//		Author author1 = new Author(1, "sravani", "yandrapati", "photo1");
//		Author author2 = new Author(2, "kala", "vuyyuri", "photo2");
//		Author author3 = new Author(3, "Anusha", "mamidisetti", "photo3");
//
//		authorRepo.save(author1);
//		authorRepo.save(author2);
//		authorRepo.save(author3);
//
//
//		User user1 = new User(1, "LOKI", "PN", "9988776622", "loki22", "1234", permrole1);
//		User user2 = new User(2, "LOKI", "KV", "9988776621", "loki21", "12345", permrole2);
//		User user3 = new User(3, "VINODH", "K", "9988776620", "loki32", "12346", permrole3);
//
//		userRepo.save(user1);
//		userRepo.save(user2);
//		userRepo.save(user3);
//		
//		BookCondition bookCondition1 = new BookCondition(1,"Good","No pages missing",250);
//		BookCondition bookCondition2= new BookCondition(2,"Bad","pages missing",100);
//		
//		bookConditionRepo.save(bookCondition1);
//		bookConditionRepo.save(bookCondition2);
//
//		//changes
//		
//	
//
//	}
//
//}

