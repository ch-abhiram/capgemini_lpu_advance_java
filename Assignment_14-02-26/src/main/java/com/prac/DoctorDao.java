package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DoctorDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void saveDoctor(Doctor d) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(d);
		et.commit();
		em.close();
	}
	
	public Doctor findDoctor(int id) {
		return em.find(Doctor.class, id);
	}
}
