package com.prac;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppointmentDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void saveAppointment(Appointment a) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(a);
		et.commit();
		
	}
	 public Appointment findAppointment(int id) {

	        EntityManager em = emf.createEntityManager();
	        Appointment ap = em.find(Appointment.class, id);
	        em.close();
	        return ap;
	    }
	
	
	 public List<Appointment> findAppointmentByDoctor(int doctorId) {

	        EntityManager em = emf.createEntityManager();

	        String jpql = "SELECT a FROM Appointment a WHERE a.doctor.id = :did";
	        TypedQuery<Appointment> query =
	                em.createQuery(jpql, Appointment.class);

	        query.setParameter("did", doctorId);

	        List<Appointment> list = query.getResultList();
	        em.close();

	        return list;
	    }
	 
	 public void updateFee(int appointmentId, double newFee) {

	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        Appointment ap = em.find(Appointment.class, appointmentId);

	        if (ap != null) {
	            et.begin();
	            ap.setFee(newFee);   
	            et.commit();
	        }

	        em.close();
	    }
}
