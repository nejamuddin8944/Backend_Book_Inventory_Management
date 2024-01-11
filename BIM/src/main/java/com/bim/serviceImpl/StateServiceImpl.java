package com.bim.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.entities.State;
import com.bim.exceptions.DuplicateStateException;
import com.bim.exceptions.NullStateListExceptione;
import com.bim.exceptions.StateNotFoundException;
import com.bim.repositories.StateRepositories;
import com.bim.response.AppResponse;
import com.bim.services.StateService;

@Service
public class StateServiceImpl implements StateService{

	@Autowired
	StateRepositories stateRepo;
	
	@Override
	public Boolean addState(State state) {
		Optional<State> opt = stateRepo.findById(state.getStateCode());
		if (opt.isPresent()) {

			throw new DuplicateStateException(new AppResponse("ADDFAIL", "State already exits"));
		}
		stateRepo.save(state);
		return true;
	}

	@Override
	public Boolean updateStateNameByCode(String stateCode, String name) {
		Optional<State> opt = stateRepo.findById(stateCode);
		if (opt.isPresent()) {
			State state = opt.get();
			state.setStateName(name);
			stateRepo.save(state);
			return true;
		}
		throw new StateNotFoundException(new AppResponse("UPDT-NAME-BY-CODE-FAIL", "State doesn't exist"));
	}

	
	@Override
	public State getStateByCode(String stateCode) {
		Optional<State> opt = stateRepo.findById(stateCode);
		if (opt.isPresent()) {
			
			return opt.get();
		}
		throw new StateNotFoundException(new AppResponse("GET_BY_CODE_FAIL", "State doesn't exist"));
	
	}

	@Override
	public List<State> getAllStates() {
		List<State> stateList = stateRepo.findAll();
		if (stateList == null || stateList.isEmpty()) {

			throw new NullStateListExceptione(new AppResponse("GETALLFAIL", "State list is empty"));
		}
		return stateList;
	}

	

}
