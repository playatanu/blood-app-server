package com.nvc.bloodapp.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nvc.bloodapp.api.models.User;


public interface UserRepositorie extends JpaRepository<User, Long>{

	public User findByEmailAndPassword(String email,String password);
	public User findByEmail(String email);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user SET user_name=?2, user_phone =?3 WHERE user_id = ?1", nativeQuery = true)
	public Integer updateNameAndPhone (Long id,String name,String phone);
	
	
	@Modifying
	@Transactional
	@Query(value= "update user set user_status = IF(user_status=1, 0, 1) where user_id =?1", nativeQuery = true)
	public Integer updateStatus (Long id);
	
	@Modifying
	@Transactional
	@Query(value= "select * FROM User where user_status =1", nativeQuery = true)
	public List<User> getActiveUsers ();
}
