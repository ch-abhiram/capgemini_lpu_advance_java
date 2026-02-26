package com.prac.springboot_task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface CustomerJpa extends JpaRepository<Customer, Integer>{
	
	
	@Modifying
	@Transactional
//	@Query("delete from Customer c where c.name=:cusname")
	@Query(value = "delete from Customer where name=:cusname",nativeQuery = true)
	public int deleteByName(@Param("cusname") String name);

}
