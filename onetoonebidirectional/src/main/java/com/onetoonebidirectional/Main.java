package com.onetoonebidirectional;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Create Person
        Person person = new Person();
        person.setName("Abhiram");
        person.setPhone(9876543210L);
        person.setEmail("abhiram@gmail.com");

        // Create Passport
        Passport passport = new Passport();
        passport.setName("Indian Passport");
        passport.setDob("01-01-2004");

        // Set relationship (VERY IMPORTANT for bidirectional)
        person.setPassport(passport);
        passport.setPerson(person);

        // Persist
        et.begin();
        em.persist(person);  // Cascade will save Passport also
        et.commit();

        System.out.println("Data Saved Successfully!");

        em.close();
        emf.close();
    }
}
