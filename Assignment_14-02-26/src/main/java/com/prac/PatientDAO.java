package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PatientDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void savePatient(Patient p) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
		
	}
	
	public Patient findPatient(int id) {
		return em.find(Patient.class, id);
	}
	
	public void updatePatient(int id,String name) {
		EntityTransaction et = em.getTransaction();
		Patient p = em.find(Patient.class, id);
		if(p!=null) {
			et.begin();
			p.setName(name);
			et.commit();
		}
		
	}
	
	public void deletePatient(int id) {
		Patient p = em.find(Patient.class, id);
		if(p!=null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(p);
			et.commit();
			
		}
	}

}
