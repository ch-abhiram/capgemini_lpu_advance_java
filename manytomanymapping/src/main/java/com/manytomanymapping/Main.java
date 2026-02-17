package com.manytomanymapping;



import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Create Subjects
        Subject sub1 = new Subject();
        sub1.setId(1);
        sub1.setName("Java");
        sub1.setNoOfDays(30);

        Subject sub2 = new Subject();
        sub2.setId(2);
        sub2.setName("SQL");
        sub2.setNoOfDays(20);

        // Create Student
        Studentt student = new Studentt();
        student.setName("Abhiram");
        student.setGender("Male");
        student.setBranch("CSE");
        
        Studentt student1 = new Studentt();
        student1.setName("ram");
        student1.setGender("Male");
        student1.setBranch("ECE");

        // Set ManyToMany relationship
        student.setSubject(Arrays.asList(sub1, sub2));
        student1.setSubject(Arrays.asList(sub1,sub2));

        // Persist data
        et.begin();

        em.persist(sub1);
        em.persist(sub2);
        em.persist(student);
        em.persist(student1);

        et.commit();

        System.out.println("Data Inserted Successfully");

        em.close();
        emf.close();
    }
}
