package com.capgemini.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.Employee;
import com.capgemini.main.JpaUtil;

@Repository
public class EmployeeDao {
	@Autowired
	JpaUtil jpa;
	EntityManager em = jpa.getEntityManager();
	public void insert(Employee e) {
		em.getTransaction().begin();
		Employee employee = findById(e.getId());
		if(employee==null) {
			em.persist(e);
		}else {
			System.out.println("Data Exist");
		}
		em.getTransaction().commit();
		
	}
	public Employee findById(int id) {
		return em.find(Employee.class, id);
	}

    public void delete(int id) {
    	Employee e = findById(id);
    		if (e != null) {
            em.remove(e);
            System.out.println("Deleted");
        }
    }
    public void update(Employee e) {
        em.merge(e);
        System.out.println("Updated");
    }
}