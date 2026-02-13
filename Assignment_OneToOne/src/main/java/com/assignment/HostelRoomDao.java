package com.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HostelRoomDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void insertData(HostelRoom room) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(room);
		et.commit();
		em.close();
		emf.close();
	}
	
	public HostelRoom findData(int id) {
		return em.find(HostelRoom.class, id);
	}

}
