package com.bim.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bim.entities.PermRole;

@Service
public interface PermRoleService {
	Boolean addPermRole(PermRole permRole);
	Boolean updatePermRole(PermRole permRole);
	Boolean deletePermRole(int roleNumber);
    PermRole getPermroleByRoleNumber(int roleNumber);
  
    List<PermRole> getAllPermRole();
    
    Boolean updatePerm(int roleNumber,String perm);

	
}


