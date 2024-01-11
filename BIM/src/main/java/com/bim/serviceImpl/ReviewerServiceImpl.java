package com.bim.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bim.entities.Reviewer;
import com.bim.exceptions.DuplicateReviewerException;
import com.bim.exceptions.ReviewerNotFoundException;
import com.bim.repositories.ReviewerRepository;
import com.bim.response.AppResponse;
import com.bim.services.ReviewerService;

@Service
public class ReviewerServiceImpl implements ReviewerService{
	
	@Autowired
	ReviewerRepository reviewerRepo;

	@Override
	public Boolean addreviewer(Reviewer reviewer) {
		 Optional<Reviewer> opt = reviewerRepo.findById(reviewer.getReviewerId());
	        if (opt.isPresent()) {
	            throw new DuplicateReviewerException(new AppResponse("ADDFAIL", "Reviewer already exists"));
	        }
	        reviewerRepo.save(reviewer);
	        return true;
	}

	@Override
	public Reviewer getReviewerByID(int reviewerId) {
		Optional<Reviewer> opt = reviewerRepo.findById(reviewerId);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new ReviewerNotFoundException(new AppResponse("GETFAIL", "Reviewer doesn't exist"));
    }
	

	@Override
	public Boolean updateName(int reviewerId, String name) {
		Optional<Reviewer> opt = reviewerRepo.findById(reviewerId);
        if (opt.isPresent()) {
            Reviewer reviewer = opt.get();
            reviewer.setName(name);
            reviewerRepo.save(reviewer);
            return true;
        }
        throw new ReviewerNotFoundException(new AppResponse("UPDT_NAME_FAIL", "Reviewer doesn't exist"));
    }
	

	@Override
	public Boolean updateEmployed(int reviewerId, String employedBy) {
		Optional<Reviewer> opt = reviewerRepo.findById(reviewerId);
        if (opt.isPresent()) {
            Reviewer reviewer = opt.get();
            reviewer.setEmployedBy(employedBy);
            reviewerRepo.save(reviewer);
            return true;
        }
        throw new ReviewerNotFoundException(new AppResponse("UPDT_EMPLOYED_FAIL", "Reviewer doesn't exist"));
    }

}
