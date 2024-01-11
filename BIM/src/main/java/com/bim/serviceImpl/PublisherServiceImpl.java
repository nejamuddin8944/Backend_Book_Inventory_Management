package com.bim.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
import org.springframework.stereotype.Service;

import com.bim.entities.Publisher;
import com.bim.entities.State;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicatePublisherException;
import com.bim.exceptions.NullPublisherListException;
import com.bim.exceptions.PublisherNotFoundException;
import com.bim.repositories.PublisherRepository;
import com.bim.response.AppResponse;
import com.bim.services.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	PublisherRepository publisherRepo;

	@Override
	public Boolean addPublisher(Publisher publisher) {
		Optional<Publisher> opt = publisherRepo.findById(publisher.getPublisherID());
		if (opt.isPresent()) {
			throw new DuplicatePublisherException(new AppResponse("SAVEFAIL", "Publisher already exist"));
		}
		publisherRepo.save(publisher);
		return true;
	}

	@Override
	public Boolean updatePublisher(Publisher publisher) {
		Optional<Publisher> opt = publisherRepo.findById(publisher.getPublisherID());
		if (opt.isPresent()) {
			publisherRepo.save(publisher);
		}
		throw new PublisherNotFoundException(new AppResponse("UPDTFAIL", "Publisher doesn't exist"));
	}

	@Override
	public Boolean deletePublisher(int publisherID) {
		Optional<Publisher> opt = publisherRepo.findById(publisherID);
		if (opt.isPresent()) {
			publisherRepo.deleteById(publisherID);
		}
		throw new PublisherNotFoundException(new AppResponse("DLTFAIL", "Publisher doesn't exist"));

	}

	@Override
	public Publisher getPublisherByPublisherID(int publisherID) {
		Optional<Publisher> opt = publisherRepo.findById(publisherID);
		if (opt.isPresent()) {
			return opt.get();
		}

		throw new PublisherNotFoundException(new AppResponse("DLTFAIL", "Publisher doesn't exist"));

	}

	@Override
	public Publisher getPublisherByName(String name) {
		Publisher publisher = publisherRepo.findByName(name);
		if(publisher!=null)
			return publisher;
		throw new PublisherNotFoundException(new AppResponse("GET_BY_NAME_FAIL", "Publisher doesn't exist with the name: "+name));
	}

	@Override
	public List<Publisher> getAllPublisher() {
		List<Publisher> publisherList = publisherRepo.findAll();
		if(publisherList==null || publisherList.isEmpty())
			throw new NullPublisherListException(new AppResponse("GET-ALL-FAIL", "Publisher list is empty"));
		return publisherList;
	}

	@Override
	public List<Publisher> getAllPublisherByCity(String city) {
		List<Publisher> publisherListByCity = publisherRepo.findByCity(city);
		if(publisherListByCity==null || publisherListByCity.isEmpty())
			throw new NullPublisherListException(new AppResponse("GET-By-City-FAIL", "Publisher in city "+city+" doesn't exist"));
		return publisherListByCity;
	}

	@Override
	public List<Publisher> getAllPublisherByState(String stateName) {
		List<Publisher> publisherListByState = publisherRepo.findByState(stateName);
		if(publisherListByState==null || publisherListByState.isEmpty())
			throw new NullPublisherListException(new AppResponse("GET-By-City-FAIL", "Publisher in state "+stateName+" doesn't exist"));
		return publisherListByState;
	}

	@Override
	public Boolean updateName(int publisherID, String name) {
		Optional<Publisher> opt = publisherRepo.findById(publisherID);
		if(opt.isPresent()) {
			
			Publisher publisher = opt.get();
			publisher.setName(name);
			publisherRepo.save(publisher);
			return true;
		}
		throw new PublisherNotFoundException(new AppResponse("GET_BY_NAME_FAIL", "Publisher doesn't exist with name "+name));
	}

	@Override
	public Boolean updateCity(int publisherID, String city) {
		Optional<Publisher> opt = publisherRepo.findById(publisherID);
		if(opt.isPresent()) {
			
			Publisher publisher = opt.get();
			publisher.setCity(city);
			publisherRepo.save(publisher);
			return true;
		}
		throw new PublisherNotFoundException(new AppResponse("GET_BY_CITY_FAIL", "Publisher doesn't exist in city "+city));
	}

	@Override
	public Boolean updateState(int publisherID, State state) {
		Optional<Publisher> opt = publisherRepo.findById(publisherID);
		if(opt.isPresent()) {
			
			Publisher publisher = opt.get();
			publisher.setState(state);
			publisherRepo.save(publisher);
			return true;
		}
		throw new PublisherNotFoundException(new AppResponse("GET_BY_STATE_FAIL", "Publisher doesn't exist in State "+state));
	
	}

}
