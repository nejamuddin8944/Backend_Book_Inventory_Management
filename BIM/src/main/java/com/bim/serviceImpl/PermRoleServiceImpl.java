package com.bim.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.entities.Book;
import com.bim.entities.Category;
import com.bim.entities.PermRole;
import com.bim.entities.Publisher;
import com.bim.exceptions.BookNotFoundException;
import com.bim.exceptions.DuplicateBookException;
import com.bim.exceptions.DuplicatePermRoleException;
import com.bim.exceptions.NullBookListExceptione;
import com.bim.exceptions.NullPermRoleListException;
import com.bim.exceptions.PermRoleNotFoundException;
import com.bim.exceptions.PublisherNotFoundException;
import com.bim.repositories.PermRoleRepository;
import com.bim.response.AppResponse;
import com.bim.services.PermRoleService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
public class PermRoleServiceImpl implements PermRoleService {
	@Autowired
	PermRoleRepository permRoleRepo;

	@Override
	public Boolean addPermRole(PermRole permRole) {
		Optional<PermRole> opt = permRoleRepo.findById(permRole.getRoleNumber());
		if (opt.isPresent()) {

			throw new DuplicatePermRoleException(new AppResponse("ADDFAIL", "Permrole already exits"));
		}
		permRoleRepo.save(permRole);
		return true;
	}

	@Override
	public Boolean updatePermRole(PermRole permRole) {
		Optional<PermRole> opt =permRoleRepo.findById(permRole.getRoleNumber());
		if(opt.isPresent())
		{
			permRoleRepo.save(permRole);
			return true;
		}
		throw new PermRoleNotFoundException(new AppResponse("UPDATE_FAIL", "Permrole does not exists"));
	}

	@Override
	public Boolean deletePermRole(int roleNumber) {
		Optional<PermRole> opt = permRoleRepo.findById(roleNumber);
		if(opt.isPresent())
		{
			permRoleRepo.deleteById(roleNumber);
			return true;
		}
		throw new PermRoleNotFoundException(new AppResponse("DELETE_FAIL", "ROLENUMBER" +roleNumber+ "does not exists"));
	}

	@Override
	public PermRole getPermroleByRoleNumber(int roleNumber) {
		Optional<PermRole> opt = permRoleRepo.findById(roleNumber);
		if(opt.isPresent())
		{
			return opt.get();
		}
		throw new PermRoleNotFoundException(new AppResponse("GET_PERMROLE_BY_ROLENUMBER_FAIL", +roleNumber+" does not exists"));
	}

	@Override
	public List<PermRole> getAllPermRole() {
		List<PermRole> permrolelist =permRoleRepo.findAll();
		if(permrolelist == null || permrolelist.isEmpty() )
		{
			throw new NullPermRoleListException(new AppResponse("GET_ALL_PERMROLE_FAIL", " Permrole does not exists"));
		}
		return null;
	}

	@Override
	public Boolean updatePerm(int roleNumber, String perm) {
		Optional<PermRole> opt = permRoleRepo.findById(roleNumber);
		if (opt.isPresent()) {

			PermRole perm1 = opt.get();
			perm1.setPerm(perm); 
			permRoleRepo.save(perm1);
			return true;
		}
		throw new BookNotFoundException(new AppResponse("UPDATE_FAIL", "Permrole doesn't exist"));
	}

}

	


		
	
	


