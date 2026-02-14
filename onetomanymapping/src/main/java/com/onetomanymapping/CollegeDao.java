package com.onetomanymapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CollegeDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public College findCollege(int id) {
		return em.find(College.class, id);
	}
	
	public void deleteClg(int id) {
		EntityTransaction et = em.getTransaction();
		College c = em.find(College.class, id);
		
		if(c!=null) {
			et.begin();
			em.remove(c);
			et.commit();
		}
	}

}
