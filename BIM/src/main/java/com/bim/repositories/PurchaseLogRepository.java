package com.bim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.bim.entities.PurchaseLog;
import com.bim.entities.PurchaseLogId;

@Service
public interface PurchaseLogRepository extends JpaRepository<PurchaseLog, PurchaseLogId>{

	
	@Query("SELECT b FROM PurchaseLog b where b.id.userId=:userId")
	List<PurchaseLog> findAllByUserId(@Param("userId") int userId);

}
