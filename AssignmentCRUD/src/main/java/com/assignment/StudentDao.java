package com.assignment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	EntityManager em = emf.createEntityManager();
	
	public void saveStudent(Student s) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
	}
	public Student findStudentById(int id) {
		return em.find(Student.class, id);
	}
	
	public List<Student> findAllStudents(){
		String jpql = "select p from Student p";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	public void updateStudent(int id, int choice, Object newValue) {

	    Student s = em.find(Student.class, id);

	    if (s == null) {
	        System.out.println("Student not found");
	        return;
	    }

	    EntityTransaction et = em.getTransaction();
	    et.begin();

	    switch (choice) {

	        case 1:
	            s.setName((String) newValue);
	            System.out.println("Name updated successfully");
	            break;

	        case 2:
	            s.setEmail((String) newValue);
	            System.out.println("Email updated successfully");
	            break;

	        case 3:
	            s.setMarks((Double) newValue);
	            System.out.println("Marks updated successfully");
	            break;

	        default:
	            System.out.println("Invalid choice");
	            et.rollback();
	            return;
	    }

	    et.commit();
	}

	
	 public void deleteStudent(int id) {
	        EntityTransaction et = em.getTransaction();
	        Student s = em.find(Student.class, id);

	        if (s != null) {
	            et.begin();
	            em.remove(s);
	            et.commit();
	            System.out.println("Student deleted successfully");
	        } else {
	            System.out.println("Student not found");
	        }
	    }
	 
	public void close() {
		em.close();
		emf.close();
	}
	

}
