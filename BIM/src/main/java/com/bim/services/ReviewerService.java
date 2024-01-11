package com.bim.services;

import org.springframework.stereotype.Service;


import com.bim.entities.Reviewer;

@Service
public interface ReviewerService {
 
	 Boolean addreviewer(Reviewer reviewer);
	 Reviewer getReviewerByID(int reviewerId);
	 Boolean updateName(int reviewerId, String name);
	 Boolean updateEmployed(int reviewerId, String employedBy);
	 
}
