package com.uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CourseDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(course);
        et.commit();
        em.close();
    }

    public Course findCourse(int id) {
        EntityManager em = emf.createEntityManager();
        Course course = em.find(Course.class, id);
        em.close();
        return course;
    }

    public List<Course> findByInstructor(int instructorId) {
        EntityManager em = emf.createEntityManager();
        Instructor instructor = em.find(Instructor.class, instructorId);
        List<Course> courses = instructor.getCourses();
        em.close();
        return courses;
    }
    
    public void deleteCourse(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        Course course = em.find(Course.class, id);
        em.remove(course);
        et.commit();
        em.close();
    }

}
