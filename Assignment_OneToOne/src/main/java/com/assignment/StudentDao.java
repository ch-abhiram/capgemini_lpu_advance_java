package com.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void insertData(Student stu) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(stu);
		et.commit();
		em.close();
		emf.close();
	}
	
	public Student findData(int id) {
		return em.find(Student.class, id);
	}
	
	public void delete(int id) {
		Student stu = em.find(Student.class, id);
		if(stu!=null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(id);
			et.commit();
			em.close();
			emf.close();
		}else {
			System.out.println("Data dosen't exsist");
		}
	}

}
