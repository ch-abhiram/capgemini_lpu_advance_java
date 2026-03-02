package com.capgemini.EMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.EMS.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String>{
	public Employee findByEmailAndPassword(String email,String password);

}
