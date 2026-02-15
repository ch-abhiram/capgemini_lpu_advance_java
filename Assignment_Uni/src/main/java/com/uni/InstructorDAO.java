package com.uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InstructorDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public void saveInstructor(Instructor instructor,InstructorProfile profile){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(profile);
		em.persist(instructor);
		et.commit();
		em.close();
		
	}
	
//	public Instructor findInstructor(int id) {
//		EntityManager em = emf.createEntityManager();
//		Instructor instructor = em.find(Instructor.class, id);
//		em.close();
//		return instructor;
//	}
	
	public Instructor findInstructorWithCourses(int id) {

	    EntityManager em = emf.createEntityManager();

	    Instructor instructor = em.createQuery(
	            "SELECT i FROM Instructor i LEFT JOIN FETCH i.courses WHERE i.id = :id",
	            Instructor.class)
	            .setParameter("id", id)
	            .getSingleResult();

	    em.close();
	    return instructor;
	}

	
	public void updateInstructor(Instructor instructor) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(instructor);
        et.commit();
        em.close();
    }
	
	public void deleteInstructor(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        Instructor instructor = em.find(Instructor.class, id);
        em.remove(instructor);
        et.commit();
        em.close();
    }
		
	}


