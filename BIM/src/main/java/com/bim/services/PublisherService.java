package com.bim.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bim.entities.Category;
import com.bim.entities.Publisher;
import com.bim.entities.State;

@Service
public interface PublisherService {
	
	 Boolean addPublisher(Publisher publisher);
	 Boolean updatePublisher(Publisher publisher);
	 Boolean deletePublisher(int publisherID);
	 Publisher getPublisherByPublisherID(int publisherID);
	 
	 List<Publisher> getAllPublisher();
	 Publisher getPublisherByName(String name);
	 List<Publisher> getAllPublisherByCity(String city);
	 List<Publisher> getAllPublisherByState(String stateCode);
	 
	 Boolean updateName(int publisherID,String name);
	 Boolean updateCity(int publisherID,String city);
	 Boolean updateState(int publisherID,State state);
	 
	 
	 
}
