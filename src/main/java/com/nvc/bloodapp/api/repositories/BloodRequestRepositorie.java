package com.nvc.bloodapp.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nvc.bloodapp.api.models.BloodRequest;

public interface BloodRequestRepositorie extends JpaRepository<BloodRequest, Long>{
//	@Modifying
//	@Transactional
	@Query(value= "select * FROM Bloodrequest where br_status =1", nativeQuery = true)
	public List<BloodRequest> getActiveBloodRequests();  
	
	@Query(value= "select * FROM Bloodrequest where user_id =?1", nativeQuery = true)
	public List<BloodRequest> getBloodRequestsByUserID(Long userId);

	@Modifying
	@Transactional
	@Query(value= "update Bloodrequest set br_status=0 where br_id =?1", nativeQuery = true)
	public Integer deActiveBloodRequestById(Long brId);  
	
	
	


}
