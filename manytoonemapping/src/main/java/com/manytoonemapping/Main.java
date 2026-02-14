package com.manytoonemapping;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Department d1 = new Department();
		d1.setId(101);
		d1.setName("IT");
		d1.setManager_name("Ramesh");
		d1.setNo_of_emp(10);
		
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("Prudhvi");
		e1.setSalary(50000);
		e1.setDesignation("Developer");
		
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("Pince");
		e2.setSalary(10000);
		e2.setDesignation("java Developer");
		
		e1.setDep(d1);
		e2.setDep(d1);
		et.begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(d1);
		et.commit();
	}

}