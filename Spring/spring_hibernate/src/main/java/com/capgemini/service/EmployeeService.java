package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dto.Employee;

public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	public void insertEmployee(Employee e) {
		if(dao.findById(e.getId()) == null) {
			dao.insert(e);
		}else {
			System.out.println("Data already exsits");
		}
	}

}
