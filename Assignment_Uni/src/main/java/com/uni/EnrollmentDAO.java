package com.uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EnrollmentDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveEnrollment(Enrollment enrollment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(enrollment);
        et.commit();
        em.close();
    }

    public void updateGrade(int id, String grade) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        Enrollment enrollment = em.find(Enrollment.class, id);
        enrollment.setGrade(grade);
        et.commit();
        em.close();
    }
    public List<Enrollment> findByCourse(int courseId) {

        EntityManager em = emf.createEntityManager();

        List<Enrollment> list = em.createQuery(
                "SELECT e FROM Enrollment e WHERE e.course.id = :cid",
                Enrollment.class)
                .setParameter("cid", courseId)
                .getResultList();

        em.close();
        return list;
    }

    public void deleteEnrollment(int id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Enrollment e = em.find(Enrollment.class, id);
        em.remove(e);
        tx.commit();
        em.close();
    }

}

