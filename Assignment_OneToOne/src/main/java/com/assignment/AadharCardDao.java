package com.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AadharCardDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void insertData(AadharCard card) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(card);
		et.commit();
		em.close();
		emf.close();
	}
	
	public AadharCard findData(int id) {
		return em.find(AadharCard.class, id);
	}

}
